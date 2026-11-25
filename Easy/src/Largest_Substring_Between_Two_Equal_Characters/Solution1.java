package Largest_Substring_Between_Two_Equal_Characters;

public class Solution1 {
    public int maxLengthBetweenEqualCharacters(String s) {
    	int max = -1;
    	
    	for(int left = 0; left < s.length()-1; left++) {
    		for(int right = left + 1; right < s.length(); right++) {
        		if(s.charAt(right) == s.charAt(left)) {
        			max = Math.max(max, right-left - 1);
        		}
        	} 
    	}
    	
    	return max;
    }
    
    public static void main(String[] args) {
    	String s = "cbzxy";
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.maxLengthBetweenEqualCharacters(s));
	}
}
