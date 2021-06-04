package Day4;
import java.util.Scanner;


public class ReverseLinkedList_II {
	/*
	Given the head of a singly linked list and two integers left and right where left <= right,
	reverse the nodes of the list from position left to position right, and return the reversed list.
	 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node<Integer> head = takeInput();
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		head = reverseBetween(head, a, b);
		
		print(head);
	}
	public static Node<Integer> reverseBetween(Node<Integer> head, int a, int b) {
		Node<Integer> temp = new Node<Integer>(0);
		temp.next = head;
		Node<Integer> pre = temp;
		Node<Integer> current = head;
		
		for(int i = 0;i<a-1;i++) {
			pre= pre.next;
			current = current.next;
		}
		Node<Integer> newPre= null;
		for(int i = 0;i<=b-a;i++) {
			Node<Integer> next = current.next;
			current.next = newPre;
			newPre = current;
			current = next;
		}
		pre.next.next = current;
		pre.next = newPre;
		
		return temp.next;
        
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
	
	public static void print(Node<Integer> head) {


		while(head != null) {
			System.out.print(head.data+" ");
			head = head.next;
			}
			System.out.println();
	}
}
