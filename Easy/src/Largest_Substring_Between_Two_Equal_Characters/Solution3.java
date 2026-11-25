package Largest_Substring_Between_Two_Equal_Characters;

import java.util.Arrays;

public class Solution3 {
    public int maxLengthBetweenEqualCharacters(String s) {
    	int max = -1;
    	int[] arr = new int[26];
    	Arrays.fill(arr, -1);
    	
    	for(int left = 0; left < s.length(); left++) {
    		if(arr[s.charAt(left) - 'a'] == -1) {
    			arr[s.charAt(left) - 'a'] = left;
    		} else {
    			max = Math.max(max, left - arr[s.charAt(left) - 'a'] - 1);
    		}
    	}
    	
    	return max;
    }
    
    public static void main(String[] args) {
    	String s = "abbabbcaccb";
    	
    	Solution3 sol3 = new Solution3();
    	System.out.println("Output: " + sol3.maxLengthBetweenEqualCharacters(s));
	}
}
