package Day23;

public class Rotate_LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public Node<Integer> rotateRight(Node<Integer> head, int k) {
	        if(head==null)
	            return null;
	        Node<Integer> current = head;
	        int len = 1;
	        while(current.next!=null) {
	            current = current.next;
	            len++;
	        }
	        current.next = head;
	        
	        k%=len;
	        // System.out.println(k);
	        for(int i=0;i<len-k;i++) {
	            current=current.next;
	        }
	        
	        head= current.next;
	        current.next= null;
	        
	        return head;
	    }

}
