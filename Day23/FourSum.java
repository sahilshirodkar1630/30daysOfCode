package Day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
/*
	Given an array nums of n integers,
	return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

		0 <= a, b, c, d < n
		a, b, c, and d are distinct.
		nums[a] + nums[b] + nums[c] + nums[d] == target
		You may return the answer in any order.

		 

		Example 1:

		Input: nums = [1,0,-1,0,-2,2], target = 0
		Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
		Example 2:

		Input: nums = [2,2,2,2,2], target = 8
		Output: [[2,2,2,2]]
		
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public List<List<Integer>> fourSum(int[] nums, int target) {
	        List<List<Integer>> output = new ArrayList<List<Integer>>();
	        
	        if(nums.length == 0){
	            return output;
	        }
	        int n = nums.length;
	        
	        Arrays.sort(nums);
	        
	        for(int i = 0;i< n;i++){
	            
	            for(int j = i+1;j < n;j++){
	                
	                int temp = target - nums[j] - nums[i];
	                
	                int front = j + 1;
	                int back = n-1;
	                while(front< back){
	                    int sum =  nums[front]+ nums[back];
	                    if(sum < temp){
	                        front++;
	                    }else if(sum>temp){
	                        back--;
	                    }else{
	                        List<Integer> quad = new ArrayList<Integer>();
	                        quad.add(nums[i]);
	                        quad.add(nums[j]);
	                        quad.add(nums[front]);
	                        quad.add(nums[back]);
	                        output.add(quad);
	                        
	                        while(front < back && nums[front] == quad.get(2)){
	                            front++;
	                        }
	                        while(front < back && nums[front] == quad.get(3)){
	                            back--;
	                        }
	                    }
	                }
	                
	                while(j+1 < n && nums[j+1] == nums[j]){
	                    j++;
	                }
	                while(i+1 < n && nums[i+1] == nums[i]){
	                    i++;
	                }
	                
	            }
	        }
	        
	        return output;
	    }

}
