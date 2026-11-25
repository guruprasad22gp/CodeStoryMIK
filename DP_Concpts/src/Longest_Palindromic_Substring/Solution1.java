package Longest_Palindromic_Substring;

public class Solution1 {
    public String longestPalindrome(String s) {
    	String ans = "";
    	int n = s.length();
    	for(int i=0;i<n;i++) {
    		for(int j=i;j<n;j++) {
    			if(palindrome(i, j, s) && ans.length() < j - i + 1) {
    				ans = s.substring(i, j+1);
    			}
    		}
    	}
    	
    	return ans;
    }
    
    private boolean palindrome(int i, int j, String s) {
    	while(i <= j) {
    		if(s.charAt(i) == s.charAt(j)) {
    			i++;
    			j--;
    		} else {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    public static void main(String[] args) {
		String s = "ababad";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.longestPalindrome(s));
	}
}
