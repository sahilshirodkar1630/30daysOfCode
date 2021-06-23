package Day22;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_II {
/*
	Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

			In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
			1                            0
		  1   1                          1
      	1   2   1                        2
      1   3   3   1                      3
	1	4	6	4	1                    4

			Example 1:

			Input: rowIndex = 3
			Output: [1,3,3,1]
			Example 2:

			Input: rowIndex = 0
			Output: [1]
			Example 3:

			Input: rowIndex = 1
			Output: [1,1]
			
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	 public List<Integer> getRow(int n) {
	        List<Integer> row , pre = null;
	            
	            for(int i = 0;i<=n;i++){
	                row = new ArrayList<Integer>();
	                for(int j = 0;j<=i;j++){
	                    if(j==0||j==i){
	                        row.add(1);
	                    }else{
	                        row.add(pre.get(j-1)+pre.get(j));
	                    }
	                }
	                pre = row;
	            }
	        return pre;
	    }

}
