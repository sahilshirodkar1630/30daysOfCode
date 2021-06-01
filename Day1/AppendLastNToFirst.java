package Day1;

import java.util.Scanner;

public class AppendLastNToFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Node<Integer> head = takeInput();
		int n = sc.nextInt();
		head = appendLastNToFirst(head, n);

		print(head);
		
		
		
	}
	
	public static  Node<Integer> appendLastNToFirst( Node<Integer> head, int n) {
		//Your code goes here
        if(head == null || head.next == null || n == 0 ){
            return head;
        }
        
         Node<Integer> slow = head;
         Node<Integer> fast = head;
        int i= 0;
        while(i< n){
            fast = fast.next;
                i++;
        }
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
                
        }
        fast.next = head;
        
        head = slow.next;

        slow.next = null;
        
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
 