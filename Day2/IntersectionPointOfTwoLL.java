package Day2;

import java.util.Scanner;



public class IntersectionPointOfTwoLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> head1 = takeInput();
		Node<Integer> head2 = takeInput();
		Node<Integer> ans = getIntersectionNode1(head1, head2);
		System.out.println(ans.data);
		

	}
	//Approach 1
	//bruteForce
	//Time m*n
	// for each node in LL1 scan all the elements in LL2 If ( any two nodes are same return yess ) 
	
	//Approach 2
	// Put all nodes of LL1 in hashmap and then traverse LL2 and check in the hashmap
	//Time O(m+n) 
	//Space O(n) for hashmap
	
	//Approach 3
	
	public static Node<Integer> getIntersectionNode1(Node<Integer> a, Node<Integer> b) {
        if(a==null||b ==null){
            return null;
        }
        Node<Integer> temp1 = a;
        Node<Integer> temp2 = b;
        
       while(temp1!=temp2){
        
           if(temp1 == null){
               temp1 = b;
           }else{
             temp1 = temp1.next;
           }
           if(temp2 == null){
               temp2 = a;
           }else{
               temp2 = temp2.next;
           }
            
       }
       return temp1;
    }
	
	
	
	
	
	//Approach 4
	// get the length of both the Lists
	// get the difference of length by doing biggerList - smaller List
	//traverse the biggerlist to diff
	//Traverse both the list and check is both nodes are same
	
	  public  Node<Integer> getIntersectionNode(Node<Integer> a, Node<Integer> b) {
	        
	        int length1 = length(a);
	        int length2 = length(b);
	        
	        int diff =0;
	        if(length1>length2){
	            diff = length1 - length2;
	            int i = 0;
	            while(i<diff){
	                a = a.next;
	                i++;
	            }
	        }else{
	            diff =  length2 - length1;
	            int i = 0;
	            while(i<diff){
	                b = b.next;
	                i++;
	            }
	        }
	        
	        while(a!=null||b!=null){
	            if(a.equals(b)){
	                break;
	            }
	            a=a.next ;
	            b= b.next;
	            
	        }
	        
	        return a;
	        
	    }
	    
	    public int length(Node<Integer> head){
	        
	        int i = 0;
	        while(head!=null){
	            i++;
	            head= head.next;
	        }
	        return i;
	    }
	public static Node<Integer> takeInput(){ // O(n)
		Node<Integer> head = null,tail = null; 
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		while(data != -1) {
			Node<Integer> newNode = new Node<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}else {
				tail.next = newNode;
				tail = tail.next; // OR tail= newNode;
				
			}
			data =sc.nextInt();
			
		}
		return head;
	}

	public static void print(Node<Integer> head) {
		
		while(head != null) {
			System.out.print(head.data+" ");
			head = head.next;
			}
			System.out.println();
	}

}
