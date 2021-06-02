package Day2;



public class MinMaxIn_BinaryTree {

	public static class Pair {
		int minimum;
		int maximum;

		public  Pair(int minimum, int maximum) {
			this.minimum = minimum;
			this.maximum = maximum;
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Pair getMinAndMax(BinaryTreeNode<Integer> root) {
		//Your code goes here
        if(root == null){
        	int min= Integer.MAX_VALUE;
        	int max =Integer.MIN_VALUE;
            Pair output = new Pair(min,max);
         
            return output;
        }
        
        Pair left = getMinAndMax(root.left);
        Pair right = getMinAndMax(root.right);
        
        int minimum =Math.min(Math.min(left.minimum,right.minimum),root.data);
        int maximum =Math.max(Math.max(left.maximum,right.maximum),root.data);
        
        Pair output = new Pair(minimum,maximum);
       
            return output;
	}

}
