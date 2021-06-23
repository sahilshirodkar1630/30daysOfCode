package Day22;

import java.util.Stack;

public class FlattenBinaryTreetoLinkedList_114 {

	/*
	Given the root of a binary tree, flatten the tree into a "linked list":
	
		The "linked list" should use the same TreeNode class where the right child pointer
		 points to the next node in the list and the left child pointer is always null.
		The "linked list" should be in the same order as a pre-order traversal of the binary tree.
		
		*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//Best Recursive Approach 
	   public void flatten(BinaryTreeNode<Integer> root) {
			flatten(root, null);
		}

		private BinaryTreeNode<Integer> flatten(BinaryTreeNode<Integer> node, BinaryTreeNode<Integer> prev) {
			if (node == null) return prev;
			prev = flatten(node.right, prev);
			prev = flatten(node.left, prev);
			node.right = prev;
			node.left = null;
			prev = node;
			return prev;
		}

	
	//Better Easier Approach        
	public static void flattenBetter(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return;
		}
		
		Stack<BinaryTreeNode<Integer>> stack = new Stack<BinaryTreeNode<Integer>>();
		 stack.push(root);
		 
		 while(!stack.isEmpty()) {
			 BinaryTreeNode<Integer> curr = stack.pop();
			 if(curr.right != null) {
				 stack.push(curr.right);
			 }
			 if(curr.left != null) {
				 stack.push(curr.left);
			 }
			 if(!stack.isEmpty()) {
					curr.right = stack.peek();
			 }
			 curr.left = null;
		 }
		
	}
	
	
	// By Using PreOrder Iterative Approach 
	 public static void Myflatten(BinaryTreeNode<Integer> root) {
		 if(root == null) {
			return;
		 }
		 
		 Stack<BinaryTreeNode<Integer>> stack = new Stack<BinaryTreeNode<Integer>>();
		
		 BinaryTreeNode<Integer> current = root;
		 BinaryTreeNode<Integer>temp = root;
		 
		 while(current!= null || !stack.isEmpty()) {
				while(current != null) {
					BinaryTreeNode<Integer> left = current.left; 
					if(current != root) {
						temp.right = current;
						temp =temp.right;
					}
					current.left = null;
					if(current.right != null) {
						stack.push(current.right);
					}
					current = left;
				}
				if(!stack.isEmpty()) {
					current = stack.pop();
				}
			}
		
	    }
	
}
