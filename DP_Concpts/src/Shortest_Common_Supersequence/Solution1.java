package Shortest_Common_Supersequence;

public class Solution1 {
	public int shortestCommonSupersequence(String str1, String str2) {
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        
        return solve(i, j, str1, str2);
    }
    
    private int solve(int i, int j, String s1, String s2) {
    	if(i < 0) {
    		return j + 1;
    	}
    	
    	if(j < 0) {
    		return i + 1;
    	}
    	
    	if(s1.charAt(i) == s2.charAt(j)) {
    		return 1 + solve(i-1, j-1, s1, s2);
    	} else {
    		int skipI = solve(i-1, j, s1, s2);
    		int skipJ = solve(i, j-1, s1, s2);
    		
    		return 1 + Math.min(skipI, skipJ);
    	}
    }
    
    public static void main(String[] args) {
    	String s1 = "efgh";
    	String s2 = "jghi";
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.shortestCommonSupersequence(s1, s2));
	}
}
