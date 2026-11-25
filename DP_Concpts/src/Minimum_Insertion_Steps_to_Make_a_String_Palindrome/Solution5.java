package Minimum_Insertion_Steps_to_Make_a_String_Palindrome;

public class Solution5 {
    public int minInsertions(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        
        for(int i=n-1;i>=0;i--) {
        	for(int j=n-1;j>=0;j--) {
        		if(s.charAt(i) == s2.charAt(j)) {
        			dp[i][j] = 1 + dp[i+1][j+1];
        		} else {
        			int skipI = dp[i+1][j];
        			int skipJ = dp[i][j+1]; 
        			
        			dp[i][j] = Math.max(skipI, skipJ);
        		}
        	}
        }
        
        return n - dp[0][0];
    }
    
    public static void main(String[] args) {
		String s = "ababa";
		
		Solution5 sol5 = new Solution5();
		System.out.println("Output: " + sol5.minInsertions(s));
	}
}