package Day28;

import java.util.*;




public class VerticalOrderTraversal {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		ArrayList<Integer> output = verticalOrderTraversal(root);
		
		for(int i : output) {
			System.out.print(i+" ");
		}
	}
	
	
	static Map<Integer,ArrayList<BinaryTreeNode<Integer>>> map = new TreeMap<>();
			
	private static ArrayList<Integer> verticalOrderTraversal(BinaryTreeNode<Integer> root) {
		
		ArrayList<Integer> output = new ArrayList<Integer>();
		helper(root,0);
		
		Set<Integer> val = map.keySet();
		
		for(Integer i : val) {
			ArrayList<BinaryTreeNode<Integer>> temp = map.get(i);
			for(BinaryTreeNode<Integer> j : temp) {
				output.add(j.data);
			}
			
		}
		
		return output;
		
		
	}



	private static void helper(BinaryTreeNode<Integer> root, int position) {
		if(root == null) {
			return ;
		}
		
		ArrayList<BinaryTreeNode<Integer>> values = map.get(position);
		
		if(values == null) {
			values = new ArrayList<BinaryTreeNode<Integer>>();
		}
		values.add(root);
		map.put(position,values);
		
		helper(root.left, position-1);
		helper(root.right, position+1);
		
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
