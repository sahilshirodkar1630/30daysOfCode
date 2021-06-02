package Day2;



public class LCAOf_BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	
	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		if(root == null){
         return -1;
        }
        if(root.data == a||root.data == b){
            return root.data;
        }
        int leftOutput;
        int rightOutput;
        if(a>root.data&&b>root.data){
             return getLCA(root.right,a,b);
           
        }else if(a<root.data&&b<root.data){
            return getLCA(root.left,a,b);
        }
        
            
        leftOutput = getLCA(root.left,a,b);
        rightOutput = getLCA(root.right,a,b);
        
        
        if(leftOutput==-1&&rightOutput==-1){
            return -1;
        }else if(leftOutput==-1){
            return rightOutput;
        }else if(rightOutput == -1){
            return leftOutput;
        }else{
            return root.data;
        }
        
       
            
        
        
        
        
        
	}
}
