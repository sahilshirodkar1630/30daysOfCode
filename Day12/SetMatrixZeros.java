package Day12;
import java.util.Scanner;

public class SetMatrixZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

		Follow up:
		A straight forward solution using O(mn) space is probably a bad idea.
		A simple improvement uses O(m + n) space, but still not the best solution.
		Could you devise a constant space solution?
		
		Example 1:
		
		Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
		Output: [[1,0,1],[0,0,0],[1,0,1]]

		Example 2:
		Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
		Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
*/
		
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int array2D[][] = new int[r][c];
		
		for(int j=0;j<r;j++) {
			for(int i=0;i<c;i++) {
				array2D[j][i] = sc.nextInt();
			}
		}
		
	}
/*
	My idea is simple: store states of each row in the first of that row, and store states of each column in the first of that column.
	Because the state of row0 and the state of column0 would occupy the same cell, I let it be the state of row0, and use another variable "col0" for column0. 
	In the first phase, use matrix elements to set states in a top-down way. In the second phase, use states to set matrix elements in a bottom-up way.
	
*/
	 public void setZeroes(int[][] matrix) {
		  int rows = matrix.length ;
		  int cols = matrix[0].length ;
		  
			 boolean temp = false;
			 //Keeping a boolean for the first row
			 
			 for(int i = 0;i<rows;i++) {
				if(matrix[i][0] == 0) temp = true;// For first col
				 for(int j = 1;j<cols;j++) {
		             if(matrix[i][j]==0) {
		                 matrix[i][0] = 0;
		                 matrix[0][j] = 0; 
					 }
				 }
				
			 }
			 
			 for(int i = rows-1;i>=0;i--) {
				
				 for(int j = cols-1;j>=1;j--) {
					 if(matrix[i][0]==0|| matrix[0][j]==0) {
						matrix[i][j] = 0;
					 }
				 }
		         if(temp) matrix[i][0] = 0;
				
			 }
	    
	 }
}
