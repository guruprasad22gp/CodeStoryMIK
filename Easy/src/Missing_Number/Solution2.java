package Missing_Number;

public class Solution2 {
    public int missingNumber(int[] nums) {
    	int xor = nums.length;
    	
    	for(int i=0;i<nums.length;i++) {
    		xor ^= i;
    		xor ^= nums[i];
    	}
    	
    	return xor;
    }

    public static void main(String[] args) {
		int[] nums = {3, 2, 0};
		
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.missingNumber(nums));
	}
}
