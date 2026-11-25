package Edit_Distance;

public class Solution3 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++) {
        	dp[i][n] = m - i;
        }
        
        for(int i=0;i<=n;i++) {
        	dp[m][i] = n - i;
        }
        
        for(int i=m-1;i>=0;i--) {
        	for(int j=n-1;j>=0;j--) {
        		if(word1.charAt(i) == word2.charAt(j)) {
        			dp[i][j] = dp[i+1][j+1];
        		} else {
        			int insert = 1 + dp[i][j+1];
        			int delete = 1 + dp[i+1][j];
        			int replace = 1 + dp[i+1][j+1];
        			
        			dp[i][j] = Math.min(replace, Math.min(delete, insert));
        		}
        	}
        }
        
        return dp[0][0];
    }
    
    public static void main(String[] args) {
    	String word1 = "intention";
    	String word2 = "execution";

    	Solution3 sol3 = new Solution3();
    	System.out.println("Output: " + sol3.minDistance(word1, word2));
	}
}
