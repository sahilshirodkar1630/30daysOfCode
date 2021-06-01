package Day1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HowManyNumbersAreSmallerThantheCurrentNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int nums[] = new int[n];
		for(int i = 0;i<n;i++ ) {
			nums[i] = sc.nextInt();
		}
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	    int output[] = nums.clone();
		
	    Arrays.sort(output);
        for(int i = 0;i<nums.length;i++){
            map.putIfAbsent(output[i],i);
        }
        
        for(int i = 0;i<nums.length;i++){
        	output[i] = map.get(nums[i]);
        	System.out.print(output[i]+" ");
        }
          
        
	}
}