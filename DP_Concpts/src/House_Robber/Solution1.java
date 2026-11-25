package House_Robber;

public class Solution1 {
	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.rob(nums));

	}
	
    public int rob(int[] nums) {
    	return solve(0, nums); 
    }
    
    private int solve(int index, int[] nums) {
    	if(index >= nums.length) {
    		return 0;
    	}
    	
    	int take = nums[index] + solve(index+2, nums);
    	int skip = solve(index+1, nums);
    	
    	return Math.max(take, skip);
    }

}
