package Largest_Divisible_Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
    	Arrays.sort(nums);
    	
    	int n = nums.length;
    	
    	int[] dp = new int[n];
    	Arrays.fill(dp, 1);
    	
    	int index[] = new int[n];
    	Arrays.fill(index, -1);
    	
    	int maxLen = 1;
    	int lastIndex = 0;
    	
    	for(int i=1;i<n;i++) {
    		for(int j=0;j<i;j++) {
    			if(nums[i] % nums[j] == 0) {			
    				if(dp[i] < dp[j] + 1) {
    					dp[i] = dp[j] + 1;
    					index[i] = j;
    				}
    				
    				if(maxLen < dp[i]) {
    					maxLen = dp[i];
    					lastIndex = i;
    				}
    			}
    		}
    	}
    	
    	ArrayList<Integer> result = new ArrayList<>();
    	
    	while(lastIndex != -1) {
    		result.add(nums[lastIndex]);
    		lastIndex = index[lastIndex];
    	}
    	result.sort((a, b) -> {
    		return Integer.compare(a, b);
    	});
    	
    	return result;
    }

    public static void main(String[] args) {
    	int nums[] = {4, 15, 32, 3, 64};
//    	3, 4, 15, 32, 64
    	Solution3 sol3 = new Solution3();
    	System.out.println("Output: " + sol3.largestDivisibleSubset(nums));
	}
}