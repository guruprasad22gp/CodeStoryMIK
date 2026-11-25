package House_Robber_II;

import java.util.Arrays;

public class Solution2 {
    public int rob(int[] nums) {
    	int n = nums.length;
    	if(n == 1) {
    		return nums[0];
    	}
    	
    	if(n == 2) {
    		return Math.max(nums[0], nums[1]);
    	}
    	 
    	return Math.max(solution(0, n-2, nums), solution(1, n-1, nums));
    }
    
    private int solution(int index, int endIndex, int[] nums) {
    	int n = nums.length;
    	int[] dp = new int[n+1];
    	Arrays.fill(dp, -1);
    	
    	return solve(index, endIndex, nums, dp);
    }
    
    private int solve(int index, int endIndex, int nums[], int[] dp) {
    	if(index > endIndex) {
    		return 0;
    	}
    	
    	if(dp[index] != -1) {
    		return dp[index];
    	}
    	
    	int take = nums[index] + solve(index+2, endIndex, nums, dp);
    	int skip = solve(index+1, endIndex, nums, dp);
    	
    	return dp[index] = Math.max(take, skip);
    }
    
    public static void main(String[] args) {
		int[] nums = {2, 3, 2};
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.rob(nums));
	}
}
