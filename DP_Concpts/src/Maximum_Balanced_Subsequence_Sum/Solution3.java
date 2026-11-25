package Maximum_Balanced_Subsequence_Sum;

public class Solution3 {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int ele: nums) {
        	max = Math.max(max, ele);
        }
        
        if(max <= 0) {
        	return max;
        }
        
        int n = nums.length;
        
        long[] dp = new long[n];
        for(int i=0;i<n;i++) {
        	dp[i] = nums[i];
        }
        
        long result = Long.MIN_VALUE;
        
        for(int i=1;i<n;i++) {
        	for(int j=0;j<i;j++) {
        		if(nums[i] - i >= nums[j] - j) {
        			dp[i] = Math.max(dp[i], dp[j] + nums[i]);
        			result = Math.max(result, dp[i]);
        		}
        	}
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	int[] nums = {3, 3, 5, 6};
    	
		Solution3 sol3 = new Solution3();
		System.out.println("Output: " + sol3.maxBalancedSubsequenceSum(nums));
	}
}