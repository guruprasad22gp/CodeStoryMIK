package Minimum_Insertion_Steps_to_Make_a_String_Palindrome;

public class Solution4 {
    public int minInsertions(String s) {
        int n = s.length();
        
        int[][] dp = new int[n+1][n+1];
        for(int len=2;len<=n;len++) {
        	for(int i=0;i+len<=n;i++) {
        		int j = i+len - 1;
        		
        		if(i >= j) {
        			dp[i][j] = 0;
        		} else if(s.charAt(i) == s.charAt(j)) {
        			dp[i][j] = dp[i+1][j-1];
        		} else {
        			dp[i][j] = Math.min(1 + dp[i+1][j], 1 + dp[i][j-1]);
        		}
        	}
        }
        
        return dp[0][n-1];
    }
    
    public static void main(String[] args) {
		String s = "leetcode";
		
		Solution4 sol4 = new Solution4();
		System.out.println("Output: " + sol4.minInsertions(s));
	}
}
