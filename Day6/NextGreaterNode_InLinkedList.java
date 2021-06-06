package Day6;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterNode_InLinkedList {

	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		int ans[] =nextLargerNodes(head);
		
		for(int i : ans) {
			System.out.print(i+" ");
		}
		
		
	}
	
	 public static int[] nextLargerNodes(Node<Integer> head) {
	        
		 Node<Integer> prev = null;
		 Node<Integer> current = head;
		 int n = 0;
		 while(current!= null) {
			 Node<Integer> next = current.next;
			 current.next = prev;
			 prev = current;
			 current = next;
			 n++;
		 }
		
		 head = prev ;
		 int[] output = new int[n];
		 
		 Stack<Integer> stack = new Stack<Integer>();
		 
		 for(int i = n-1 ; head!=null && i>=0;i--) {
			
			 if(stack.isEmpty()) {
				 output[i] = 0;
			 }
			 
			 if(!stack.isEmpty() && stack.peek()> head.data) {
				 output[i] = stack.peek();
			 }else {
				 
				 while(!stack.isEmpty() && stack.peek() <= head.data) {
					 stack.pop();
				 }
				 
				 if(stack.isEmpty()) {
					 output[i] = 0;
				 }else {
					 output[i] = stack.peek();
				 }
				 
			 }
			 stack.add(head.data);
			 head = head.next;
			 
		 }
		 return output;
	    
	 }
	
	
	 public static void print(Node<Integer> head) {
			
			while(head != null) {
				System.out.print(head.data+" ");
				head = head.next;
				}
				System.out.println();
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

}
