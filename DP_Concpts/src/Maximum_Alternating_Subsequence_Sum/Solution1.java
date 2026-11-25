package Maximum_Alternating_Subsequence_Sum;

public class Solution1 {
	public static void main(String[] args) {
		 int[] nums = {4,2,5,3};
		 Solution1 sol1 = new Solution1();
		 
		 System.out.println("Output: " + sol1.maxAlternatingSum(nums));
	} 
	
    public long maxAlternatingSum(int[] nums) {
    	int index = 0;
    	boolean isEven = true;
    	return solve(index, isEven, nums);
    }
    
    private int solve(int i, boolean isEven, int[] nums) {
    	if(i == nums.length) {
    		return 0;
    	}
    	
    	int skip = solve(i+1, isEven, nums);
    	
    	int val = nums[i];
    	if(!isEven) {
    		val = -val;
    	} 
    	int take = solve(i+1, !isEven, nums) + val;
    	System.out.println("Skip: " + skip + ": val: " + val + ": Take: " + take);

    	return Math.max(take, skip);
    }
}
