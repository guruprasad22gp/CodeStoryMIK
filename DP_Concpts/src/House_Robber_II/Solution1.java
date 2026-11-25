package House_Robber_II;

public class Solution1 {
    public int rob(int[] nums) {
    	int n = nums.length;
    	
    	return Math.max(solve(0, n-1, nums), solve(1, n, nums));
    }
    
    private int solve(int index, int endIndex, int nums[]) {
    	if(index >= endIndex) {
    		return 0;
    	}
    	
    	int take = nums[index] + solve(index+2, endIndex, nums);
    	int skip = solve(index+1, endIndex, nums);
    	
    	return Math.max(take, skip);
    }
    
    public static void main(String[] args) {
		int[] nums = {2, 3, 2};
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.rob(nums));
	}
}