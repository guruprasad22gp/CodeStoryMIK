package Longest_Common_Subsequence;

public class Solution1 {
    public int longestCommonSubsequence(String text1, String text2) {
    	int i = 0;
    	int j = 0;
    	
    	return solve(i, j, text1, text2);
    }
    
    private int solve(int i, int j, String text1, String text2) {
    	if(i >= text1.length() || j >= text2.length()) {
    		return 0;
    	}
    	
    	int take = 0;
    	if(text1.charAt(i) == text2.charAt(j)) {
    		take = 1 + solve(i+1, j+1, text1, text2);
    	}
    	
    	int skipI = solve(i+1, j, text1, text2);
    	int skipJ = solve(i, j+1, text1, text2);
    	
    	return Math.max(take, Math.max(skipI, skipJ));
    }
    
    public static void main(String[] args) {
    	String text1 = "abc";
    	String text2 = "def";
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.longestCommonSubsequence(text1, text2));
	}
}
