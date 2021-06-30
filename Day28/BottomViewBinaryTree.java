package Day28;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class BottomViewBinaryTree {


	public static class Pair{
		
		BinaryTreeNode<Integer> root;
		int position;
		
		Pair(BinaryTreeNode<Integer> root , int position){
			this.root = root;
			this.position = position;
		}
		
	}

	public static void main(String[] args) {

		BinaryTreeNode<Integer> root = takeInputLevelWise();
		ArrayList<Integer> output =  bottomViewBinaryTree(root);
		
		 for(int i : output ) {
			 System.out.print(i +" ");
		 }
		 
	}
	
	static Map<Integer,Integer> map = new TreeMap<>();
	

	private static ArrayList<Integer> bottomViewBinaryTree(BinaryTreeNode<Integer> root) {

		ArrayList<Integer> output = new ArrayList<Integer>();
		
		helper(root,0);
		
		Set<Integer> set = map.keySet();
		
		for(Integer i : set) {
			
			output.add(map.get(i));
		}
		
		return output;
		
	}



	private static void helper(BinaryTreeNode<Integer> root, int position) {
		
		Queue<Pair> queue = new LinkedList<>();
		Pair p = new Pair(root, position);
		
		queue.add(p);
		
		while(!queue.isEmpty()) {
			Pair frontNode = queue.poll();
			
			map.put(frontNode.position, frontNode.root.data);
			
			if(frontNode.root.left != null) {
				Pair leftPair = new Pair(frontNode.root.left, frontNode.position-1);
				queue.add(leftPair);
			}
			if(frontNode.root.right != null) {
				Pair rightPair = new Pair(frontNode.root.right, frontNode.position+1);
				queue.add(rightPair);
			}
		}
		
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
