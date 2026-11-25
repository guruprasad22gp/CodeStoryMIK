package Longest_Increasing_Subsequence;

import java.util.Arrays;

public class Solution3 {
    public int lengthOfLIS(int[] nums) {
    	int n = nums.length;
    	int[] dp = new int[n];
    	Arrays.fill(dp, 1);
    	int result = 0;
    	
    	for(int i=1;i<n;i++) {
    		for(int j=0;j<i;j++) {
    			if(nums[i] > nums[j]) {
    				dp[i] = Math.max(dp[i], dp[j] + 1);
    				result = Math.max(result, dp[i]);
    			}
    		}
    	}
    	
    	for(int ele: dp) {
    		System.out.print(ele + " ");
    	}
    	System.out.println();
    	
    	return result;
    }
    
    public static void main(String[] args) {
    	int nums[] = {1,3,6,7,9,4,10,5,6};
    	Solution3 sol3 = new Solution3();
    	System.out.println("Output: " + sol3.lengthOfLIS(nums));
	}
}