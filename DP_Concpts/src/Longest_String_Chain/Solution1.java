package Longest_String_Chain;

import java.util.Arrays;

public class Solution1 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> {
         	if(a.length() == b.length()) {
        		return a.compareTo(b);
        	}
        	return a.length() - b.length();
        });
        
        for(String s: words) {
        	System.out.println(s);
        }
        
        return solve(words, 0, -1);
    }
    
    private int solve(String[] words, int i, int prevIdx) {
    	if(i >= words.length) {
    		return 0;
    	}
    	
    	int skip = solve(words, i+1, prevIdx);
    	
    	int take = 0;
    	 
    	if(prevIdx == -1 || (words[i].length() - words[prevIdx].length() == 1 && isPredecessor(words[i], words[prevIdx]))) {
    		take = 1 + solve(words, i+1, i);
    	}
    	
    	return Math.max(skip, take);
    }
    
    private boolean isPredecessor(String a, String b) {
    	int m = a.length();
    	int n = b.length();
    	int i = 0;
    	int j = 0;
    	while(i < m && j < n) {
    		if(a.charAt(i) == b.charAt(j)) {
    			j++;
    		}
    		i++;
    	}
    	
    	return j == n;
    }

	public static void main(String[] args) {
		String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.longestStrChain(words));
	}
}
