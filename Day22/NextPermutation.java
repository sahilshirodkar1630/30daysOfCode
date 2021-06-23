package Day22;

public class NextPermutation {

	/*
		Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
		If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
		The replacement must be in place and use only constant extra memory.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public void nextPermutation(int[] nums) {
	        int first =  -1;
	        int n = nums.length-1;
	        for(int i = n-1;i>=0;i--){
	            if(nums[i]<nums[i+1]){
	                first= i;
	                break;
	            }
	        }
	        
	         if(first!=-1){
	            int sec = 0;
	            for(int i = n;i>=0;i--){
	                if(nums[i]>nums[first]){
	                    sec= i;
	                    break;
	                }
	            }

	            int temp = nums[first];
	            nums[first] = nums[sec];
	            nums[sec] = temp;
	        }
	        first++;
	        while(first<n){
	            int temp = nums[first];
	            nums[first] = nums[n];
	            nums[n] = temp;
	            first++;
	            n--;
	        }
	    }

}
