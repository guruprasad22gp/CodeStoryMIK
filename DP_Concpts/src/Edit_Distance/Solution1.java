package Edit_Distance;

public class Solution1 {
    public int minDistance(String word1, String word2) {
        return solve(0, 0, word1, word2);
    }
    
    private int solve(int i, int j, String s1, String s2) {
    	if(i >= s1.length()) {
    		return s2.length() - j;
    	}
    	
    	if(j >= s2.length()) {
    		return s1.length() - i;
    	}
    	
    	if(s1.charAt(i) == s2.charAt(j)) {
    		return solve(i+1, j+1, s1, s2);
    	} else {
    		int insert = 1 + solve(i, j+1, s1, s2);
    		int delete = 1 + solve(i+1, j, s1, s2);
    		int replace = 1 + solve(i+1, j+1, s1, s2);
    		return Math.min(replace, Math.min(delete, insert));
    	}
    }
    
    public static void main(String[] args) {
    	String word1 = "horse";
    	String word2 = "ros";

    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.minDistance(word1, word2));
	}
}
