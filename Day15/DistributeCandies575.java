package Day15;

import java.util.HashMap;
import java.util.Scanner;

public class DistributeCandies575 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new  int[n];
		for(int j=0;j<n;j++) {
			arr[j]= sc.nextInt();
		}
		
		System.out.println(distributeCandies(arr));
	}
	 	public static int distributeCandies(int[] candyType) {
	        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
	        for(int i : candyType) {
	        	if(!map.containsKey(i)) {
	        		map.put(i,true);
	        	}
	        }
	        return Math.min(candyType.length, map.size());
	    }

}
