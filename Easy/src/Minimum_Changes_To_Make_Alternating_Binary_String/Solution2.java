package Minimum_Changes_To_Make_Alternating_Binary_String;

public class Solution2 {
    public int minOperations(String s) {
        int start_with_0 = 0;
        int start_with_1 = 0;
        
        for(int i=0;i<s.length();i++) {
        	if(i % 2 == 0) {
        		if(s.charAt(i) == '0') {
        			start_with_1++;
        		} else {
        			start_with_0++;
        		}
        	} else {
        		if(s.charAt(i) == '1') {
        			start_with_1++;
        		} else {
        			start_with_0++;
        		}
        	}
        }
        
        return Math.min(start_with_0, start_with_1);
    }
    
    public static void main(String[] args) {
		String s = "01101";
		
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.minOperations(s));
	}
}
