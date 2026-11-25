package Longest_Palindromic_Substring;

import java.util.Arrays;

public class Solution3 {
	int[][] dp;
    public String longestPalindrome(String s) {
    	String result = "";
    	int n = s.length();
    	
    	dp = new int[n+1][n+1];
    	for(int[] x: dp) {
    		Arrays.fill(x, -1);
    	}
    	
    	for(int i=0;i<n;i++) {
    		for(int j=i;j<n;j++) {
    			if(((dp[i][j] == 1) || (dp[i][j] == -1 && palindrome(i, j, s))) && result.length() < j - i + 1) {
    				result = s.substring(i, j+1);
    			}
    		}
    	}
    	
    	return result;
    }
    
    private boolean palindrome(int i, int j, String s) {
    	if(i > j) {
    		return true;
    	}
    	
    	if(dp[i][j] != -1) {
    		return dp[i][j] == 1? true: false;
    	}
    	
    	if(s.charAt(i) == s.charAt(j)) {
    		dp[i][j] = palindrome(i+1, j-1, s)? 1: 0;
    		return dp[i][j] == 1? true: false;
    	}
    	dp[i][j] = 0;
    	return false;
    }
    
    public static void main(String[] args) {
		String s = "ananna";
		Solution3 sol3 = new Solution3();
		System.out.println("Output: " + sol3.longestPalindrome(s));
	}
}