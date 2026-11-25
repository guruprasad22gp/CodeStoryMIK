package Longest_Common_Subsequence_Printing;

public class Solution1 {
    public String longestCommonSubsequence(String text1, String text2) {
    	int m = text1.length();
    	int n = text2.length();
    	
    	int[][] dp = new int[m+1][n+1];
    	
    	for(int i=m-1;i>=0;i--) {
    		for(int j=n-1;j>=0;j--) {
    			if(text1.charAt(i) == text2.charAt(j)) {
    				dp[i][j] = 1 + dp[i+1][j+1];
    			} else {
    				dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
    			}
    		}
    	}
    	
    	int i = 0;
    	int j = 0;
    	StringBuilder result = new StringBuilder();
    	while(i < m && j < n) {
    		if(text1.charAt(i) == text2.charAt(j)) {
    			result.append(text1.charAt(i));
    			i++;
    			j++;
    		} else {
    			if(dp[i+1][j] > dp[i][j+1]) {
    				i++;
    			} else {
    				j++;
    			}
    		}
    	}
    	
    	for(int[] x: dp) {
    		for(int ele: x) {
    			System.out.print(ele + " ");
    		}
    		System.out.println();
    	}
    	
    	return result.toString();
    }

    public static void main(String[] args) {
    	String text1 = "xiyjsseaefebrz";
    	String text2 = "xyzae";
    	Solution1 sol1 = new Solution1();
		
    	System.out.println("Output: " + sol1.longestCommonSubsequence(text1, text2));
	}
}
