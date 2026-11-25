package Isomorphic_Strings;

import java.util.Arrays;

public class Solution2 {
    public boolean isIsomorphic(String s, String t) {
        int[] arrS = new int[256];
        Arrays.fill(arrS, -1);
        int[] arrT = new int[256];
        Arrays.fill(arrT, -1);
        
        
        for(int i=0;i<s.length();i++) {
        	char chS = s.charAt(i);
        	char chT = t.charAt(i);
        	
        	if((arrS[chS] != -1 && arrS[chS] != chT) || (arrT[chT] != -1 && arrT[chT] != chS)) {
        		return false;
        	}
        	
        	arrS[chS] = chT;
        	arrT[chT] = chS;
        }
        
        return true;
    }

    public static void main(String[] args) {
    	String s = "egeg";
    	String t = "adad";
    	
    	Solution2 sol2 = new Solution2();
    	System.out.println("Output: " + sol2.isIsomorphic(s, t));
	}
}
