package Day22;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	/*
	 Given an integer numRows, return the first numRows of Pascal's triangle.
	
	In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
	
			1                            0
		  1   1                          1
      	1   2   1                        2
      1   3   3   1                      3
	1	4	6	4	1                    4

	Example 1:
	
	Input: numRows = 5
	Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
	Example 2:
	
	Input: numRows = 1
	Output: [[1]]
	 
	Constraints:
	1 <= numRows <= 30
	Accepted
	523,278
	Submissions
	913,631
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public List<List<Integer>> generate(int n) {
	        List<List<Integer>> output = new  ArrayList<>();
	        List<Integer> res ,  pre = null;
	        
	        for(int i = 0;i<n;i++){
	            res = new ArrayList<Integer>();
	            for(int j = 0;j<=i;j++){
	                if(j==0 || j==i){
	                    res.add(1);
	                }else{
	                    res.add(pre.get(j-1)+pre.get(j));
	                }
	            }
	            pre = res;
	            output.add(res);
	        }
	    
	        return output;
	    }

}
