package Day1;

import java.util.Scanner;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node<Integer> head = takeInput();
		head = OddEvenLinkedList(head);
		print(head);
	}
	
	
	public static  Node<Integer> OddEvenLinkedList( Node<Integer> head) {
		//Your code goes here
        
         Node<Integer> oddHead =  null;
         Node<Integer> oddTail =  null;
         Node<Integer> evenHead =  null;
         Node<Integer> evenTail =  null;
    
        while(head != null){
             Node<Integer> temp = new  Node<Integer>(head.data);
            if(temp.data %2==0){
                if(evenHead == null){
                    evenHead = temp;
                    evenTail = temp;
                    head= head.next;
                }else{
                evenTail.next = temp;
                    evenTail =  evenTail.next;
                head = head.next;
                }
            }else{
                if(oddHead == null){
                    oddHead = temp;
                	oddTail = temp;
                    head= head.next;
                }else{
                
                oddTail.next = temp;
                oddTail = oddTail.next;
                head = head.next;
                }
            }
        }
        if(oddHead ==  null){
            return evenHead;
        }
        if(evenHead == null){
            return oddHead;
        }
        oddTail.next = null;
        evenTail.next = null;
       
        oddTail.next =evenHead;
        
        
        return oddHead;
        
        
        
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
