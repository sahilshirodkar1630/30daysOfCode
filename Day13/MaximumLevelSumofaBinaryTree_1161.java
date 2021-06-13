package Day13;

import java.util.LinkedList;
import java.util.Queue;



public class MaximumLevelSumofaBinaryTree_1161 {

	/*
	
	Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

	Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

	Example 1:
	Input: root = [1,7,0,7,-8,null,null]
	Output: 2
	Explanation: 
	Level 1 sum = 1.
	Level 2 sum = 7 + 0 = 7.
	Level 3 sum = 7 + -8 = -1.
	So we return the level with the maximum sum which is level 2.
	
	Example 2:
	Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
	Output: 2
	

*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int maxLevelSum(BinaryTreeNode<Integer> root) {
	        
	        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
	        int max = Integer.MIN_VALUE;
	        int sum = 0;
	        int level= 1;
	        int maxlevel=1;
	        
	        queue.add(root);
	        
	        queue.add(null);
	        
	        while(!queue.isEmpty()){
	        	BinaryTreeNode<Integer> frontNode = queue.remove();
	            if(frontNode == null){
	                if(sum>max){
	                    max = sum;
	                    maxlevel = level;
	                }
	                sum = 0;
	                level++;
	                if(!queue.isEmpty()){
	                queue.add(null);
	                }else{
	                    break;
	                }
	            }else{
	                sum+= frontNode.data;
	                if(frontNode.left!= null){
	                    queue.add(frontNode.left);
	                }            
	                
	                 if(frontNode.right != null){
	                    queue.add(frontNode.right);
	                }          
	            }
	            

	        }
	        return maxlevel;
	        
	        
	        
	        
	        
	    }

}
