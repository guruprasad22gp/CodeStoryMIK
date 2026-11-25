package House_Robber;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.rob(nums));

	}
	
	int[] dp;
    public int rob(int[] nums) {
    	dp = new int[nums.length+1];
    	Arrays.fill(dp, -1);
    	return solve(0, nums); 
    }
    
    private int solve(int index, int[] nums) {
    	if(index >= nums.length) {
    		return 0;
    	}
    	
    	if(dp[index] != -1) {
    		return dp[index];
    	}
    	
    	int take = nums[index] + solve(index+2, nums);
    	int skip = solve(index+1, nums);
    	
    	return dp[index] = Math.max(take, skip);
    }

}
