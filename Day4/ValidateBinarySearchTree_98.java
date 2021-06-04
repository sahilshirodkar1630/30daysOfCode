package Day4;



public class ValidateBinarySearchTree_98 {
/*
	Given the root of a binary tree, determine if it is a valid binary search tree (BST).

	A valid BST is defined as follows:

	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
	public static void main(String[] args) {
	
*/	
	  public boolean isValidBST(BinaryTreeNode<Integer> root) {
		  
		  return isValid(root, null, null);
		  
	  }

	  public boolean isValid(BinaryTreeNode<Integer> root, Integer min, Integer max) {
	        
		  if(root == null) return true;
	        
		  if(min != null && root.data <= min) return false;    
		  if(max != null && root.data >= max) return false;
  
		  return isValid(root.left, min, root.data) && isValid(root.right, root.data, max);
	   }


}
