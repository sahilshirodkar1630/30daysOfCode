package Day13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Day12.BinaryTreeNode;



public class BST_From_LinkedList {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node<Integer> head = takeInput();
		BinaryTreeNode<Integer> bstRoot = sortedListToBST(head);
		printLevelWise(bstRoot);
		
	}
	public static BinaryTreeNode<Integer> sortedListToBST(Node<Integer> head) {
	      
		return Helper(head,null);
	    
	}
	    public static  BinaryTreeNode<Integer> Helper(Node<Integer> head,Node<Integer> tail){
	        if(head == tail){
	            return null;
	        }
	        Node<Integer> slow = head;
	        Node<Integer> fast = head;
	        
	        while(fast.next != tail && fast.next.next != tail){
	            slow = slow.next;
	            fast = fast.next.next;   
	        }
	        
	        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(slow.data);
	        
	        
	        root.left = Helper(head,slow);
	        root.right = Helper(slow.next,tail);
	        
	        return root;
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
	    
	    public static void printLevelWise(BinaryTreeNode<Integer> root) {
			
			Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
			queue.add(root);
			
			while(!queue.isEmpty()) {
				
				BinaryTreeNode<Integer> frontNode;
				try {
					frontNode = queue.remove();
					String s = frontNode.data+":";
					if(frontNode.left==null) {
						s+= "L:-1"+",";
					}else {
						s+="L:"+frontNode.left.data+",";
						queue.add(frontNode.left);
					}
					
					if(frontNode.right==null) {
						s+= "R:-1";
					}else {
						s+="R:"+frontNode.right.data;
						queue.add(frontNode.right);
					}
					System.out.println(s);
					
				} catch ( Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

}
