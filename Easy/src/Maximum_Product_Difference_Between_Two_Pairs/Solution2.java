package Maximum_Product_Difference_Between_Two_Pairs;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		int[] nums = {5,6,2,7,4};
		
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.maxProductDifference(nums));

	}
	
    public int maxProductDifference(int[] nums) {
    	Arrays.sort(nums);
    	
    	return (nums[nums.length-1] * nums[nums.length-2]) - (nums[0] * nums[1]);
    }
}
