package Longest_Palindromic_Substring;

public class Solution4 {
    public String longestPalindrome(String s) {
    	int n = s.length();
    	boolean[][] palindrome = new boolean[n+1][n+1];
    	
    	for(int len=1;len<=n;len++) {
    		for(int i=0;i+len<=n;i++) {
    			int j = i+len-1;
    			
    			if(i == j) {
    				palindrome[i][j] = true;
    			} else if(i+1 == j) {
    				palindrome[i][j] = s.charAt(i) == s.charAt(j);
    			} else {
    				palindrome[i][j] = (s.charAt(i) == s.charAt(j) && palindrome[i+1][j-1]);
    			}
    		}
    	}
    	 
    	String res = "";
    	for(int i=0;i<n;i++) {
    		for(int j=i;j<n;j++) {
    			if(palindrome[i][j] && res.length() < j-i+1) {
    				res = s.substring(i, j+1);
    			}
    		}
    	}
    	
    	return res;
    }
    
    public static void main(String[] args) {
		String s = "abvc";
		Solution4 sol4 = new Solution4();
		System.out.println("Output: " + sol4.longestPalindrome(s));
	}
}