package Longest_Palindromic_Subsequence;

public class Solution1 {
    private int longestCommonSubsequence(String s1) {
    	String s2 = new StringBuilder(s1).reverse().toString();
    	int n = s1.length();
    	
    	int[][] dp = new int[n+1][n+1];
    	
    	for(int i=n-1;i>=0;i--) {
    		for(int j=n-1;j>=0;j--) { 
    			if(s1.charAt(i) == s2.charAt(j)) {
    				dp[i][j] = 1 + dp[i+1][j+1];
    			} else {
    				int skipI = dp[i+1][j];
    				int skipJ = dp[i][j+1];
    				
    				dp[i][j] = Math.max(skipI, skipJ);
    			}
    		}
    	}
    	
    	return dp[0][0];
    }
    
    
    public static void main(String[] args) {
		String s = "bbbab";
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.longestCommonSubsequence(s));
	}
}
