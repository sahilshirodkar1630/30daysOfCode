package Day9;

import java.util.Arrays;

public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public int firstMissingPositive(int[] nums) {
        
        Arrays.sort(nums);
        int count = 1;
        int lastcount = 0;
        for(int i: nums){
            if(i>0){
                if(i!=count){
                    if(i!=lastcount){
                    return count;
                    }
                }else{
                  
                        count++;
                        lastcount++;
    
                }
            }
        }
        return count;
    }

}
