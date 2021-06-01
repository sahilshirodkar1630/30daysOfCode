package Day1;

import java.util.Scanner;

public class AddTwoNumbersII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head1 = takeInput();
		Node<Integer> head2 = takeInput();
		Node<Integer> output = addTwoNumbers( head1,head2);

		print(output);
	}
	  public static Node<Integer> addTwoNumbers(Node<Integer> one, Node<Integer> two) {
	        one = reverseList(one);
	        two = reverseList(two);
	        
	        Node<Integer> newhead = new Node<Integer>(0);
	        Node<Integer> temp = newhead;
			int carry = 0;
			while(one!=null || two!=null || carry == 1 ) {
				int sum = 0;
				if(one != null) {
					sum += one.data;
					one = one.next;
				}
				if(two != null) {
					sum += two.data;
					two = two.next;
				}
				sum += carry;
				int newData = sum % 10;
				carry = sum / 10;
				Node<Integer> newNode = new Node<Integer>(newData);
				temp.next = newNode;
				temp = temp.next;
			}
	        
	        newhead = reverseList(newhead.next);
	        return newhead;
	    }
	    public static Node<Integer> reverseList(Node<Integer> head) {
	        if(head==null|| head.next==null){
	            return head;
	        }
	        Node<Integer> prev = null;
	        Node<Integer> current = head;
	        
	        while(current!=null){
	        	Node<Integer> next = current.next;
	            current.next=prev;
	            prev = current;
	            current= next;
	        }
	        
	        return prev;
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
