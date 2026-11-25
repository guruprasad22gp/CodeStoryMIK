package Largest_Positive_Integer_That_Exists_With_Its_Negative;

import java.util.Arrays;

public class Solution1 {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        
        int i = 0;
        int j = nums.length-1;
        while(i < j) {
        	if(nums[i] == -nums[j]) {
        		return nums[j];
        	} else if(nums[i] < -nums[j]) {
        		i++;
        	} else {
        		j--;
        	}
        	
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
		int[] nums = {-1,10,6,7,-7,1};
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.findMaxK(nums));
	}
}
