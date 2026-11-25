package Longest_Increasing_Subsequence;

import java.util.LinkedList;

public class Solution4 {
    public int lengthOfLIS(int[] nums) {
    	int n = nums.length;
    	LinkedList<Integer> list = new LinkedList<>();
    	
    	for(int i=0;i<n;i++) {
    		int index = binarySearch(list, nums[i]);
    		
    		if(index == list.size()) {
    			list.add(nums[i]);
    		} else {
    			list.set(index, nums[i]);
    		}
    		
    		System.out.println("Output: " + list);
    	}
    	 
    	System.out.println(list);
    	return list.size();
    }
    
    private int binarySearch(LinkedList<Integer> list, int key) {
    	int left = 0;
    	int right = list.size();
    	
    	int result = list.size();
    	
    	while(left < right) {
    		int mid = left + (right - left)/2;
    		
    		if(list.get(mid) < key) {
    			left = mid + 1;
    		} else {
    			result = mid;
    			right = mid;
    		}
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
    	int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
    	Solution4 sol4 = new Solution4();
    	System.out.println("Output: " + sol4.lengthOfLIS(nums));
	}
}