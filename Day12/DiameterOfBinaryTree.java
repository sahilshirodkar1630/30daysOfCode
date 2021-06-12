package Day12;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class DiameterOfBinaryTree {
	
	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		System.out.println("Diameter : "+diameter(root).daimeter);
		System.out.println("Height : "+diameter(root).height);
		System.out.println(Diameter(root));
		
	}
	
	  public static class Pair {
	        int height;
	        int daimeter;
	    }

		public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
			//Your code goes here
	        return diameter(root).daimeter;
		}
		
	    public static Pair diameter(BinaryTreeNode<Integer> root){
	        if(root == null){
	            Pair p = new Pair();
	            p.height = 0;
	            p.daimeter = 0;
	            return p;
	        }
	        // Calling Left and right Childrens
	        Pair left = diameter(root.left);
	     	Pair right = diameter(root.right);
	        
	        //Calculating height  
	        int height  = Math.max(left.height,right.height)+1;
	        
	        // geting daimeter options
	        int op1 = left.daimeter ;
	        int op2 = right.daimeter ;
	        int op3 = left.height+right.height+1;
	        // Calculating Daimeter
	        int daimeter = Math.max(op3,Math.max(op1,op2));
	        
	        // returning Pair
	        Pair ans = new Pair();
	        ans.height = height;
	        ans.daimeter = daimeter;
	        return ans;
	        
	    }



//	public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root){
//	
//		if(root == null) {
//			Pair<Integer, Integer> ans = new Pair<Integer, Integer>();
//			ans.first= 0;
//			ans.second =0;
//			return ans;
//		}
//		
//		Pair<Integer, Integer> lAns = heightDiameter(root.left);
//		
//		Pair<Integer, Integer> rAns = heightDiameter(root.right);
//		
//		
//		
//		int height= 1+Math.max(lAns.first, rAns.first);
//		
//		int option1 = lAns.first+rAns.first;
//		int option2 = lAns.second;
//		int option3 = rAns.second;
//		
//		int diameter = Math.max(option1, Math.max(option2, option3));
//		
//		Pair<Integer, Integer> ans = new Pair<Integer, Integer>();
//		ans.first = height;
//		ans.second = diameter;
//		return ans;
//		
//		
//		
//	}
	
	public static int Diameter(BinaryTreeNode<Integer> root) {
		if(root == null ) {
			return 0;
		}
		int option1 = height(root.left)+height(root.right);
		int option2 = Diameter(root.left);
		int option3 = Diameter(root.right);
		
		return Math.max(option1,Math.max(option2, option3));
	}
	
	public static int height(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int lh =  height(root.left);
		int rh = height(root.right);
		return Math.max(lh, rh)+1;
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
