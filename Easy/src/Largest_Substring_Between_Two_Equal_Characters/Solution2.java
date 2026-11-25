package Largest_Substring_Between_Two_Equal_Characters;

import java.util.HashMap;

public class Solution2 {
    public int maxLengthBetweenEqualCharacters(String s) {
    	int max = -1;
    	HashMap<Character, Integer> map = new HashMap<>();
    	
    	for(int left = 0; left < s.length(); left++) {
    		if(!map.containsKey(s.charAt(left))) {
    			map.put(s.charAt(left), left);
    		} else {
    			max = Math.max(max, left - map.get(s.charAt(left)) - 1);
    		}
    	}
    	
    	return max;
    }
    
    public static void main(String[] args) {
    	String s = "abbabbcaccb";
    	
    	Solution2 sol2 = new Solution2();
    	System.out.println("Output: " + sol2.maxLengthBetweenEqualCharacters(s));
	}
}
