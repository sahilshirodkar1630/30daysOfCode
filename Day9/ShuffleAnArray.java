package Day9;

import java.util.Random;

public class ShuffleAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {

	    int[] nums;
	    Random random;
	    public Solution(int[] nums) {
	        
	        this.nums = nums;
	        random = new Random();
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        return nums;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        int copy[] = nums.clone();
	        for(int i = 0;i<nums.length;i++){
	            int j = random.nextInt(i+1);
	            swap(copy,i,j);
	        }
	       
	        return copy;
	        
	    }
	    
	    private void swap(int arr[],int i ,int j){
	        int temp = arr[j];
	        arr[j] = arr[i];
	        arr[i] = temp;
	        
	    }
	}

}
