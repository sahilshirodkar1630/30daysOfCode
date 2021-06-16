package Day16;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SymmetricTree {

	/*
	Given the root of a binary tree,check whether it is a mirror of itself (i.e., symmetric around its center).
	
	Example 1:
	Input: root = [1,2,2,3,4,4,3]
	Output: true
	
	Example 2:
	Input: root = [1,2,2,null,3,null,3]
	Output: false
	
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		System.out.println(isSymmetric(root));
		
	}
	
	// Rcursive
	public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return true;
		}	
		return  isSymmetric(root.right, root.left);
	}
	
	public static boolean isSymmetric(BinaryTreeNode<Integer> root1,BinaryTreeNode<Integer>  root2) {
		if(root1 == null  && root2 ==  null) {
			return true;
		}else if(root1 == null || root2 == null) {
			return false;
		}
		if(root1.data != root2.data) {
			return false;
		}
		
		boolean left = isSymmetric(root1.left,root2.right);
		boolean right = isSymmetric(root1.right,root2.left);
		
		return left && right;
		
	}
	
	//Iterative
	public boolean isSymmetricIterative(BinaryTreeNode<Integer> root) {
        if(root == null)
            return true;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList();
       
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
        	BinaryTreeNode<Integer> left = q.poll();
        	BinaryTreeNode<Integer> right = q.poll();
            if(left == null && right == null)
                continue;
            if(left == null || right == null ||left.data != right.data )
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
            
        }
        return true;
            
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
