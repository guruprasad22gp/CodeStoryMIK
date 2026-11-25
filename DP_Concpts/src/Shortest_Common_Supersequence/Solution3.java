package Shortest_Common_Supersequence;

public class Solution3 {
	public int shortestCommonSupersequence(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		
		int[][] dp = new int[m+1][n+1];
		for(int i=m;i>=0;i--) {
			for(int j=n;j>=0;j--) {
				if(i == m) {
					dp[i][j] = n - j;
				} else if(j == n) {
					dp[i][j] = m - i;
				} else if(str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = 1 + dp[i+1][j+1];
				} else { 
					dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		
		return dp[0][0];
	}
	
    public static void main(String[] args) {
    	String s1 = "efgh";
    	String s2 = "jghi";
    	
    	Solution3 sol3 = new Solution3();
    	System.out.println("Output: " + sol3.shortestCommonSupersequence(s1, s2));
	}
}
