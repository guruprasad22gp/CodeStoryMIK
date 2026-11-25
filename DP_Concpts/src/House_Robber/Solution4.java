package House_Robber;

public class Solution4 {
	public static void main(String[] args) {
		int[] nums = {2,1,1,2};
		
		Solution4 sol4 = new Solution4();
		System.out.println("Output: " + sol4.rob(nums));
		System.out.println("Output: " + sol4.rob1(nums));

	}
	
	public int rob1(int[] nums) {
		if(1 == nums.length) {
			return nums[0];
		}
		
		int secPrev = nums[0];
		int prev = Math.max(secPrev, nums[1]);
		
		for(int i=2;i<nums.length;i++) {
			int t = Math.max(secPrev + nums[i], prev);
			secPrev = prev;
			prev = t;
		}
		
		return prev;
	}
	
    public int rob(int[] nums) {
    	int n = nums.length;
    	
    	if(n == 1) {
    		return nums[0];
    	}
    	
    	if(n == 2) {
    		return Math.max(nums[0], nums[1]);
    	}
    	
    	int secondPrev = nums[0];
    	int prev = Math.max(secondPrev, nums[1]);
    	int result = prev;
    	
    	for(int i=2;i<n;i++) {
    		int take = secondPrev + nums[i];
    		int skip = prev;
    		
    		result = Math.max(take, skip);
    		
    		secondPrev = Math.max(prev, secondPrev);
    		prev = result;
    	}
    	
    	return result;
    }
}
