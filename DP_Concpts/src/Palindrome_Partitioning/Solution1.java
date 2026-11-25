package Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	List<List<String>> result;
	boolean[][] palindrome;
    public List<List<String>> partition(String s) {
    	int n = s.length();
    	palindrome = new boolean[n][n];
    	
    	for(int len=1;len<=n;len++) {
    		for(int i=0;i+len<=n;i++) {
    			int j = i + len -1;
    			if(i == j) {
    				palindrome[i][j] = true;
    			} else if(i+1 == j) {
    				palindrome[i][j] = s.charAt(i) == s.charAt(j);
    			} else {
    				palindrome[i][j] = (s.charAt(i) == s.charAt(j) && palindrome[i+1][j-1]);
    			}
    		}
    	}
    	
    	result = new ArrayList<List<String>>();
    	List<String> curr = new ArrayList<>();
    	
    	solve(s, 0, curr);
    	
    	return result;
    }
    
    private void solve(String s, int i, List<String> curr) {
    	if(i >= s.length()) {
    		result.add(new ArrayList<String>(curr));
    		return;
    	}
    	
    	for(int idx=i;idx<s.length();idx++) {
    		if(palindrome[i][idx]) {
    			curr.add(s.substring(i, idx+1));
    			solve(s, idx+1, curr );
    			curr.removeLast();
    		}
    	}
    }

	public static void main(String[] args) {
		String s = "aac";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.partition(s));
	}
}