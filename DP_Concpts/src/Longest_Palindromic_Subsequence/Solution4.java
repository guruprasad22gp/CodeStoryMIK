package Longest_Palindromic_Subsequence;

public class Solution4 {
    public int longestPalindromeSubseq(String s) {
    	int n = s.length();
    	int[][] dp = new int[n][n];
    	
    	for(int i=n-1;i>=0;i--) {
    		for(int j=0;j<n;j++) {
    			if(i > j) {
    				dp[i][j] = 0;
    			} else if(i == j) {
    				dp[i][j] = 1;
    			} else if(s.charAt(i) == s.charAt(j)) {
    				dp[i][j] = 2 + dp[i+1][j-1];
    			} else {
    				int skipI = dp[i+1][j];
    				int skipJ = dp[i][j-1];
    				
    				dp[i][j] = Math.max(skipI, skipJ);
    			}
    		}
    	}
    	
    	return dp[0][n-1];
    }
    
    public static void main(String[] args) {
		String s = "guruprasad";
		
		Solution4 sol4 = new Solution4();
		System.out.println("Output: " + sol4.longestPalindromeSubseq(s));
	}
}
