package Day2;

import java.util.Scanner;

public class DetectACycleInLinkedList {

	/*
	 Approach 1 
	Use HashMap
	check if any element is present in the mashmap 
	if not then put the element in HashMap
	If yes then return that node 

	*/
	 public boolean hasCycle(Node<Integer> head) {
	      if(head == null|| head.next == null){
	          return false;
	      }
	        
	      Node<Integer> slow = head;
	      Node<Integer> fast = head;
	        
	        while(fast.next != null && fast.next.next != null){
	            
	         slow = slow.next;
	         fast=fast.next.next;
	            if(slow == fast){
	                return true;
	            }
	            
	        }
	        return false;
	        
	        
	    }

}
