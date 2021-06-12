package Day12;

import java.util.Scanner;

public class MaximumSumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc= new Scanner(System.in);
		 int n = sc.nextInt();
		 int arr[] = new  int[n];
	     for(int j = 0; j < n; j++) {
	    	 arr[j]=sc.nextInt();  
	     }
	     
	     System.out.println(maximumSumSubarray(arr));
	     
	     
	}

	
	public static int maximumSumSubarray(int[] arr) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			
			if(sum<0) {
				sum = 0;
			}
			if(sum>max) {
				max = sum;
			}
		}
		
		return max;
	}
}
