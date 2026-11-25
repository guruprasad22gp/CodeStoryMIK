package Largest_Positive_Integer_That_Exists_With_Its_Negative;

public class Solution2 {
    public int findMaxK(int[] nums) {
        int n = nums.length;
        int maxEle = -1;
        for(int i=0;i<n;i++) {
        	for(int j=i+1;j<n;j++) {
        		if(nums[i] == -nums[j] && maxEle < Math.max(nums[i], nums[j])) {
        			maxEle = Math.max(nums[i], nums[j]);
        		}
        	}
        }
        
        return maxEle;
    }
    
    public static void main(String[] args) {
		int[] nums = {-1,2,-3,3};
		
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.findMaxK(nums));
	}
}
