package Longest_Palindromic_Subsequence;

public class Solution2 {
    public int longestPalindromeSubseq(String s) {
    	return solve(0, s.length()-1, s);
    }
    
    private int solve(int i, int j, String s) {
    	if(i > j) {
    		return 0;
    	}
    	
    	if(i == j) {
    		return 1;
    	}
    	
    	if(s.charAt(i) == s.charAt(j)) {
    		return 2 + solve(i+1, j-1, s);
    	} else {
    		int skipI = solve(i+1, j, s);
    		int skipJ = solve(i, j-1, s);
    		return Math.max(skipI, skipJ);
    	}
    }
        
    public static void main(String[] args) {
		String s = "guruprasad";
		
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.longestPalindromeSubseq(s));
	}
}
