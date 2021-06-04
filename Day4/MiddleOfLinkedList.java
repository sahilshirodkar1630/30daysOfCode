package Day4;

import java.util.Scanner;

public class MiddleOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> head = takeInput();
		Node<Integer> middle = middle(head);
		System.out.println(middle.data);
				

	}
	  	
	public static  Node<Integer> middle( Node<Integer> head) {      
		if(head == null ||head.next == null){     
			return head;	        
		}
	          
		Node<Integer> fast = head;    
		Node<Integer> slow = head;
		while(fast != null && fast.next != null ) { 
			slow = slow.next;
			fast= fast.next.next;
		}
		return slow;
		
	}
	
	
	private static void display(Node<Integer> head) {
		// TODO Auto-generated method stub
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}

	public static Node<Integer> takeInput() // O(n)
	{
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
