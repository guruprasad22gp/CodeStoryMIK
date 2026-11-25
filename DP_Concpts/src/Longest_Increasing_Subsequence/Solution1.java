package Longest_Increasing_Subsequence;

public class Solution1 {
    public int lengthOfLIS(int[] nums) {
    	int i = 0;
    	int prevIdx = -1;
    	return solve(i, prevIdx, nums);
    }
    
    private int solve(int i, int prevIdx, int[] nums) {
    	if(i >= nums.length) {
    		return 0;
    	}
    	
    	int skip = solve(i+1, prevIdx, nums);
    	int take = 0;
    	if(prevIdx == -1 || nums[prevIdx] < nums[i]) {
    		take = 1 + solve(i+1, i, nums);
    	}
    	
    	return Math.max(take, skip);
    }
    
    public static void main(String[] args) {
    	int nums[] = {10,9,2,5,3,7,101,18};
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.lengthOfLIS(nums));
	}
}