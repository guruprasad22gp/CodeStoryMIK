package Shortest_Common_Supersequence;

import java.util.Arrays;

public class Solution2 {
	int[][] dp;
	public int shortestCommonSupersequence(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		
		dp = new int[m][n];
		for(int[] x: dp) {
			Arrays.fill(x, -1);
		}
		
		int i = m-1;
		int j = n-1;
		
		return solve(i, j, str1, str2);
	}
	
	private int solve(int i, int j, String s1, String s2) {
		if(i < 0) {
			return j+1;
		}
		
		if(j < 0) {
			return i+1;
		}
		
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		
		if(s1.charAt(i) == s2.charAt(j)) {
			return dp[i][j] = 1 + solve(i-1, j-1, s1, s2);
		} else {
			int skipI = 1 + solve(i-1, j, s1, s2);
			int skipJ = 1 + solve(i, j-1, s1, s2);
			
			return dp[i][j] = Math.min(skipI, skipJ);
		}
	}
	
    public static void main(String[] args) {
    	String s1 = "geek";
    	String s2 = "eke";
    	
    	Solution2 sol2 = new Solution2();
    	System.out.println("Output: " + sol2.shortestCommonSupersequence(s1, s2));
	}
}
