package Minimum_Changes_To_Make_Alternating_Binary_String;

public class Solution1 {
    public int minOperations(String s) {
        int operations = 0;
        char start = '0';
        for(char ch: s.toCharArray()) {
        	if(start == ch) {
        		operations++;
        	}
          	start = start == '0'? '1': '0';
        }
        
        return Math.min(operations, s.length() - operations);
    }
    
    public static void main(String[] args) {
		String s = "0100";
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minOperations(s));
	}
}
