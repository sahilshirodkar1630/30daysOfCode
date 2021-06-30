package Day28;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class LeftSideView_BinaryTree {

	public static class Pair{
		BinaryTreeNode<Integer> root;
		int position;
		
		Pair(BinaryTreeNode<Integer> root , int position){
			this.root = root;
			this.position = position;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTreeNode<Integer> root = takeInputLevelWise();
		 ArrayList<Integer> output =  leftViewBinaryTree(root);
		
		 for(int i : output ) {
			 System.out.print(i +" ");
		 }
	}
	

// Time O(n) and Space O(N)
	private static ArrayList<Integer> leftViewBinaryTree(BinaryTreeNode<Integer> root) {
		
		ArrayList<Integer> output = new ArrayList<Integer>();
		
		  Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
	        queue.offer(root);
	        queue.offer(null);
	        boolean flag = true;
	        while(!queue.isEmpty()) {
					BinaryTreeNode<Integer> frontNode = queue.poll();
					if(flag) {
						output.add(frontNode.data);
						flag =false;
					}
					if(frontNode==null) {
						if(queue.isEmpty()) {
							break;
						}
						System.out.println();
						queue.offer(null);
						flag = true;
					}else {
//						System.out.print(frontNode.data+" ");
						if(frontNode.left!=null) {
							queue.offer(frontNode.left);
						}
						if(frontNode.right!=null) {
							queue.offer(frontNode.right);
							
						}
						
					}
	        }
	        return output;
					
				
		
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
				BinaryTreeNode<Integer> frontNode = queue.poll();
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


}
