package Palindromic_Substrings;

public class Solution5 {
    public int countSubstrings(String s) {
    	int count = 0;
    	int n = s.length();
    	
    	for(int i=0;i<n;i++) {
    		count += checkPalindrome(i, i, s);
    		count += checkPalindrome(i, i+1, s);
    	}
    	
    	return count;
    }
    
    private int checkPalindrome(int i, int j, String s) {
    	int count = 0;
    	
    	while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
    		if(j - i + 1 >= 2) {
    			count++;
    		}
    		i--;
    		j++;
    	}
    	
    	return count;
    }

    public static void main(String[] args) {
		String s = "abaab";
		
		Solution5 sol5 = new Solution5();
		System.out.println("Output: " + sol5.countSubstrings(s));
	}
}