package Day1;
import java.util.Scanner;

public class EliminateduplicatesfromLL {

	/*
	 
	 Eliminate duplicates from LL
	You have been given a singly linked list of integers where the elements are sorted in ascending order. 
	Write a function that removes the consecutive duplicate values such that 
	the given list only contains unique elements and returns the head to the updated list.
	 
	 Sample Input 1 :
	1
	1 2 3 3 3 3 4 4 4 5 5 7 -1
	Sample Output 1 :
	1 2 3 4 5 7 
	Sample Input 2 :
	2
	10 20 30 40 50 -1
	10 10 10 10 -1
	Sample Output 2 :
	10 20 30 40 50
	10
	 */
	
	public static void main(String args[]) {
		Node<Integer> head = takeInput();
		head = removeDuplicates(head);
		print(head);
	}
	
public static  Node<Integer> removeDuplicates( Node<Integer> head) {
        
        if(head==null || head.next==null) {
			return head;
		}
        
		 Node<Integer> slow=head;
		 Node<Integer> fast=head.next;
		
		while(fast !=null) {
			if(slow.data.equals(fast.data)) {
				fast=fast.next;
			}else {
				slow.next=fast;
				slow=slow.next;
				fast=fast.next;
			}
		}
		slow.next=null;
		return head;
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

