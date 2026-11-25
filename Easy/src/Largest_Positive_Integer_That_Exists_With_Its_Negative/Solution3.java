package Largest_Positive_Integer_That_Exists_With_Its_Negative;

import java.util.HashSet;

public class Solution3 {
    public int findMaxK(int[] nums) {
    	HashSet<Integer> number = new HashSet<>();
    	int maxEle = -1;
    	
    	for(int ele: nums) {
    		if(number.contains(-ele)) {
    			maxEle = Math.max(maxEle, Math.max(ele, -ele));
    		} else {
    			number.add(ele);
    		}
    	}
    	
    	return maxEle;
    }
    
    public static void main(String[] args) {
		int[] nums = {-1,10,6,7,-7,1};
		
		Solution3 sol3 = new Solution3();
		System.out.println("Output: " + sol3.findMaxK(nums));
	}
}
