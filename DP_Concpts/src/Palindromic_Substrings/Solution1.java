package Palindromic_Substrings;

public class Solution1 {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        for(int i=0;i<n;i++) {
        	for(int j=i;j<n;j++) {
        		if(isPalindrome(i, j, s)) {
        			count++;
        		}
        	}
        }
        
        return count;
    }
    
    private boolean isPalindrome(int start, int end, String s) {
    	while(start <= end) {
    		if(s.charAt(start) != s.charAt(end)) {
    			return false;
    		}
    		
    		start++;
    		end--;
    	}
    	
    	return true;
    }

    public static void main(String[] args) {
		String s = "aaaa";
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.countSubstrings(s));
	}
}
