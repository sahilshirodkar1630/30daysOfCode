package Day13;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
/*
	You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. 
	The binary tree has the following definition:

		struct Node {
		  int val;
		  Node *left;
		  Node *right;
		  Node *next;
		}
		Populate each next pointer to point to its next right node. 
		If there is no next right node, the next pointer should be set to NULL.

		Initially, all next pointers are set to NULL.
		Follow up:
		You may only use constant extra space.
		Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
	*/
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public Node connect(Node root) {
	        if(root == null){
	            return root;
	        }
	        
	          Queue<Node> queue = new LinkedList<Node>();
		        Node temp = root;
		        queue.add(root);
		        queue.add(null);
		        
		        while(!queue.isEmpty()){
		        	Node frontNode = queue.remove();
	               
		            if(frontNode == null){
		             
		                if(!queue.isEmpty()){
		                queue.add(null);
		                }else{
		                    break;
		                }
		            }else{
		               frontNode.next = queue.peek();
	                    
		                if(frontNode.left!= null){
		                    queue.add(frontNode.left);
		                }            
		                
		                 if(frontNode.right != null){
		                    queue.add(frontNode.right);
		                }          
		            }
		            

		        }
	        return temp;
	        
	    }

}
