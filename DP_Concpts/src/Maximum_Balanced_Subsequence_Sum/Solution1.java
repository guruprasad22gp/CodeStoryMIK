package Maximum_Balanced_Subsequence_Sum;

public class Solution1 {
    public long maxBalancedSubsequenceSum(int[] nums) {
    	int max = Integer.MIN_VALUE;
    	for(int ele: nums) {
    		max = Math.max(max, ele);
    	}
    	
    	if(max <= 0) {
    		return max;
    	}
    	
        int idx = 0;
        int prevIdx = -1;
        
        return solve(idx, prevIdx, nums);
    }
    
    private int solve(int i, int prevIdx, int[] nums) {
    	if(i >= nums.length) {
    		return 0;
    	}
    	
    	int skip = solve(i+1, prevIdx, nums);
    	
    	int take = prevIdx == -1? 0: nums[prevIdx];
    	
    	if(prevIdx == -1 || nums[i] - i >= nums[prevIdx] - prevIdx) {
    		take = nums[i] + solve(i+1, i, nums);
    	}
    	
    	return Math.max(skip, take);
    }
    
    public static void main(String[] args) {
		int[] nums = {-1, -3};
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxBalancedSubsequenceSum(nums));
	}
}
