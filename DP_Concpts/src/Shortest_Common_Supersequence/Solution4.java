package Shortest_Common_Supersequence;

public class Solution4 {
	public int shortestCommonSupersequence(String str1, String str2) {
		int n = longestCommonSequence(str1, str2);
		
//		n + str1.length() - n + str2.length() - n;
		return str1.length() - n + str2.length();
	}
	
	private int longestCommonSequence(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i=m-1;i>=0;i--) {
			for(int j=n-1;j>=0;j--) {
				if(s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = 1 + dp[i+1][j+1];
				} else {
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		
		return dp[0][0];
	}
	
    public static void main(String[] args) {
    	String s1 = "efgh";
    	String s2 = "jghi";
    	
    	Solution4 sol4 = new Solution4();
    	System.out.println("Output: " + sol4.shortestCommonSupersequence(s1, s2));
	}
}
