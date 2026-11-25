package Palindrome_Partitioning_II;

public class Solution4{
    public int minCut(String s) {
        int n = s.length();
        
        boolean[][] palindrome = new boolean[n][n];
        for(int len=1;len<=n;len++) {
        	for(int i=0;i+len<=n;i++) {
        		int j = i + len - 1;
        		
        		if(i == j) {
        			palindrome[i][j] = true;
        		} else if(i + 1 == j) {
        			palindrome[i][j] = s.charAt(i) == s.charAt(j);
        		} else {
        			palindrome[i][j] = (s.charAt(i) == s.charAt(j) && palindrome[i+1][j-1]);
        		}
        	}
        }
        
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--) {
        	for(int j=0;j<n;j++) {
        		if(i > j) {
        			dp[i][j] = 0;
        		} else if(palindrome[i][j]) {
        			dp[i][j] = 0;
        		} else {
        			int result = Integer.MAX_VALUE;
        			for(int k=i;k<j;k++) {
        				int ans = 1 + dp[i][k] + dp[k+1][j];
        				result = Math.min(ans, result);
        			}
        			
        			dp[i][j] = result;
        		}
        	}
        }
        
        return dp[0][n-1];
    }
    
    public static void main(String[] args) {
		String s = "aab";
		
		Solution4 sol4 = new Solution4();
		System.out.println("Output: " + sol4.minCut(s));
	}
}
