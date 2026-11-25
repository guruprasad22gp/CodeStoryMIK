package House_Robber_II;

public class Solution4 {
    public int rob(int[] nums) {
    	int n = nums.length;
    	if(n == 1) {
    		return nums[0];
    	}
    	
    	if(n == 2) {
    		return Math.max(nums[0], nums[1]);
    	}
    	
    	int secPrev = nums[0];
    	int prev = Math.max(nums[1], secPrev);
    	
    	for(int i=2;i<n-1;i++) {
    		int t = Math.max(prev, secPrev + nums[i]);
    		secPrev = prev;
    		prev = t;
    	}
    	
    	int res = prev;
    	
    	secPrev = nums[1];
    	prev = Math.max(nums[2], secPrev);
    	
    	for(int i=3;i<n;i++) {
    		int t = Math.max(prev, secPrev + nums[i]);
    		secPrev = prev;
    		prev = t;
    	}
    	
    	return Math.max(prev, res);
    }
    
    public static void main(String[] args) {
		int[] nums = {1,3,1,3,100};
		Solution4 sol4 = new Solution4();
		System.out.println("Output: " + sol4.rob(nums));
	}
}
