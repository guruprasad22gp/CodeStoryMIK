package Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	List<List<String>> result;
    public List<List<String>> partition(String s) {
    	List<String> curr = new ArrayList<>();
    	result = new ArrayList<>();
    	
    	solve(s, 0, curr);
    	
    	return result;
    }
    
    private void solve(String s, int idx, List<String> curr) {
    	if(idx >= s.length()) {
    		result.add(new ArrayList<String>(curr));
    		return;
    	}
    	
    	for(int i=idx;i<s.length();i++) {
    		if(palindrome(s, idx, i)) {
    			curr.addLast(s.substring(idx, i+1));
    			solve(s, i+1, curr);
    			curr.removeLast();
    		}
    	}
    }
    
    private boolean palindrome(String s, int i, int j) {
    	while(i < j) {
    		if(s.charAt(i) != s.charAt(j)) {
    			return false;
    		}
    		i++;
    		j--;
    	}
    	
    	return true;
    }

	public static void main(String[] args) {
		String s = "guru";
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.partition(s));
	}
}
