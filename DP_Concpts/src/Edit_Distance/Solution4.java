package Edit_Distance;

public class Solution4 {
	int m;
	int n;
    public int minDistance(String word1, String word2) {
       m = word1.length();
       n = word2.length();
       
       return solve(m, n, word1, word2);
    }
    
    private int solve(int i, int j, String s1, String s2) {
    	if(i == 0) {
    		return j;
    	} else if(j == 0) {
    		return i;
    	}
    	
    	if(s1.charAt(i-1) == s2.charAt(j-1)) {
    		return solve(i-1, j-1, s1, s2);
    	} else {
    		int insert = 1 + solve(i, j-1, s1, s2);
    		int delete = 1 + solve(i-1, j, s1, s2);
    		int replace = 1 + solve(i-1, j-1, s1, s2);
    		
    		return Math.min(replace, Math.min(delete, insert));
    	}
    }
    
    public static void main(String[] args) {
    	String word1 = "horse";
    	String word2 = "ros";

    	Solution4 sol4 = new Solution4();
    	System.out.println("Output: " + sol4.minDistance(word1, word2));
	}
}
