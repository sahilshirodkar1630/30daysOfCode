package Day1;

import java.util.Scanner;

public class AddTwoNumbersLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head1 = takeInput();
		Node<Integer> head2 = takeInput();
		Node<Integer> output = addtwoNumbers( head1,head2);

		print(output);
	}
	
	// 2 4 3
	// 5 6 4
private static Node<Integer> addtwoNumbers(Node<Integer> a, Node<Integer> b) {
		// TODO Auto-generated method stub
	
	Node<Integer> newhead = new Node<Integer>(0);
	Node<Integer> temp = newhead;
	int carry = 0;
	while(a != null || b!= null || carry == 1 ) {
		int sum = 0;
		if(a != null) {
			sum+= a.data;
			a= a.next;
		}
		if(b != null) {
			sum+= b.data;
			b= b.next;
		}
		sum += carry;
		int val = sum%10;
		carry= sum/10;
		
		Node<Integer> newNode = new Node<Integer>(val);
		temp.next = newNode ;
		temp = temp.next;
		
		
	}
	return newhead.next;
	
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


