package Minimum_Insertion_Steps_to_Make_a_String_Palindrome;

public class Solution3 {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        
        for(int i=n-1;i>=0;i--) {
        	for(int j=0;j<n;j++) {
        		if(i >= j) {
        			dp[i][j] = 0;
        		}else if(s.charAt(i) == s.charAt(j)) {
        			dp[i][j] = dp[i+1][j-1];
        		} else {
        			int skipI = 1 + dp[i+1][j];
        			int skipJ = 1 + dp[i][j-1];
        			
        			dp[i][j] = Math.min(skipI, skipJ);
        		}
        	}
        }
        
        return dp[0][n-1];
    }
    
    public static void main(String[] args) {
		String s = "leetcode";
		
		Solution3 sol3 = new Solution3();
		System.out.println("Output: " + sol3.minInsertions(s));
	}
}
