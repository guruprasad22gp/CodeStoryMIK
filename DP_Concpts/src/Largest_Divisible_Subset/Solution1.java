package Largest_Divisible_Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
    	
    	return solve(0, -1, nums);
    }
    
    private List<Integer> solve(int i, int prevI, int[] nums) {
    	if(i >= nums.length) {
    		return new ArrayList<>();
    	}
    	
    	List<Integer> skip = solve(i+1, prevI, nums);
    	
    	List<Integer> take = new ArrayList<>();
    	
    	if(prevI == -1 || nums[i] % nums[prevI] == 0) {
    		take.add(nums[i]);
    		List<Integer> temp = solve(i+1, i, nums);
    		take.addAll(temp);
    	}
    	
    	return skip.size() < take.size()? take: skip;
    }

    public static void main(String[] args) {
    	int nums[] = {4, 15, 32, 3, 64};
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.largestDivisibleSubset(nums));
	}
}
