package Day4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class LinkedListInBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTreeNode<Integer> root = takeInputLevelWise();
		Node<Integer> head = takeInput();
		
		System.out.println(isSubPath(head, root));
	}
	
	 public static boolean isSubPath(Node<Integer> head, BinaryTreeNode<Integer> root) {
	 
		
		 if(root == null) {
			return false;
		 }
		 if(root.data == head.data) {
			if(searchPath(head,root)) {
				return true;
			}
		 }
		 
		 
		return isSubPath(head, root.left) || isSubPath(head, root.right);
		 
		 
	    
	 }
	 
	
	private static boolean searchPath(Node<Integer> head, BinaryTreeNode<Integer> root) {
		// TODO Auto-generated method stub
		if(root == null) {
			return head==null;
		}
		
		if(head==null) {
			return true;
		}
		
		if(head.data != root.data) {
			return false;
		}
		
		return searchPath(head.next, root.left) || searchPath(head.next, root.right);
		
	}

	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter root data");
		
		int rootData = sc.nextInt();
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.add(root);
		while(!queue.isEmpty()) {
			try {
				BinaryTreeNode<Integer> frontNode = queue.remove();
				System.out.println("Enter left child of "+ frontNode.data);
				int left =sc.nextInt();
				if(left !=-1) {
				BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<Integer>(left);
				frontNode.left= leftNode;
				queue.add(leftNode);
				}
				System.out.println("Enter right child of "+ frontNode.data);
				int right =sc.nextInt();
				if(right!=-1) {
				BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<Integer>(right);
				frontNode.right= rightNode;
				queue.add(rightNode);
	
				}
				
			} catch ( Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
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

}
