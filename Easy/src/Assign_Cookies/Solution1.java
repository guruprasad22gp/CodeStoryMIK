package Assign_Cookies;

import java.util.Arrays;

public class Solution1 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        
        int i = 0;
        int j = 0;
        
        int m = g.length;
        int n = s.length;
        int count = 0;
        
        while(i < m && j < n) {
        	if(s[j] >= g[i]) {
        		count++;
        		i++;
        	}
        	j++;
        	
        }
        
        return count;
    }
    
    public static void main(String[] args) {
    	int[] g = {1,2,3};
    	int[] s = {1,1};

    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.findContentChildren(g, s));
	}
}
