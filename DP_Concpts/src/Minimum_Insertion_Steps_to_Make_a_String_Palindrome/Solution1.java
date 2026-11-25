package Minimum_Insertion_Steps_to_Make_a_String_Palindrome;

public class Solution1 {
    public int minInsertions(String s) {
        return solve(0, s.length()-1, s);
    }
    
    private int solve(int i, int j, String s) {
    	if(i > j) {
    		return 0;
    	}
    	
    	if(s.charAt(i) == s.charAt(j)) {
    		return solve(i+1, j-1, s);
    	} else {
    		int skipI = 1 + solve(i+1, j, s);
    		int skipJ = 1 + solve(i, j-1, s);
    		
    		return Math.min(skipI, skipJ);
    	}
    }
    
    public static void main(String[] args) {
		String s = "leetcode";
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minInsertions(s));
	}
}