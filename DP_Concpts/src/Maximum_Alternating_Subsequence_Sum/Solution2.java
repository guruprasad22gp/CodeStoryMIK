package Maximum_Alternating_Subsequence_Sum;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		 int[] nums = {4,2,5,3};
		 Solution2 sol2 = new Solution2();
		 
		 System.out.println("Output: " + sol2.maxAlternatingSum(nums));
	} 
	
	long[][] dp;
	public long maxAlternatingSum(int[] nums) {
		int n = nums.length;
		dp = new long[n+1][3];
		for(long[] x: dp) {
			Arrays.fill(x, -1);
		}
		
		int index = 0;
		boolean isEven = true;
	   
		return solve(index, isEven, nums);
	}
   
	private long solve(int i, boolean isEven, int nums[]) {
		if(i == nums.length) {
			return 0;
		}
		
		int secIdx = isEven? 1: 0;
		if(dp[i][secIdx] != -1) {
			return dp[i][secIdx];
		}
		
		long skip = solve(i+1, isEven, nums);
	   
		 int val = nums[i];
		if(!isEven) {
			val = -val;
		}
	   
		long take = solve(i+1, !isEven, nums) + val;
	   
		return dp[i][secIdx] = Math.max(take, skip);
   }
}
