package Longest_String_Chain;

import java.util.Arrays;

public class Solution3 {
    public int longestStrChain(String[] words) {
    	int n = words.length;
    	
    	int[] dp = new int[n+1];
    	Arrays.fill(dp, 1);
    	
    	int result = 1;
    	
    	Arrays.sort(words, (a, b) -> {
    		if(a.length() == b.length()) {
    			return a.compareTo(b);
    		}
    		
    		return a.length() - b.length();
    	});
    	
    	for(int i=1;i<n;i++) {
    		for(int j=0;j<i;j++) {
    			if(words[i].length() - words[j].length() == 1 && isPredecessor(words[i], words[j])) {
    				dp[i] = Math.max(dp[i], dp[j] + 1);
    				result = Math.max(result, dp[i]);
    			}
    		}
    	}
    	
    	return result;
    }
    
    private boolean isPredecessor(String a, String b) {
    	int i = 0;
    	int j = 0;
    	int m = a.length();
    	int n = b.length();
    	
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
		
		Solution3 sol3 = new Solution3();
		System.out.println("Output: " + sol3.longestStrChain(words));
	}
}
