package Missing_Number;

import java.util.Arrays;

public class Solution3 {
	public static void main(String[] args) {
		int[] nums = {3, 2, 0, 4, 5, 1, 6};
		
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.missingNumber(nums));
	}
	
    public int missingNumber(int[] nums) {
    	Arrays.sort(nums);
    	return binarySearch(nums);
    }
    
    private int binarySearch(int[] nums) {
    	int left = 0;
    	int right = nums.length-1;
    	int result = nums.length;
    	
    	while(left <= right) {
    		int mid = left + (right - left)/2;
    		
    		if(nums[mid] > mid) {
    			result = mid;
    			right = mid - 1;
    		} else {
    			left = mid + 1;
    		}
    	}
    	
    	return result;
    }
}
