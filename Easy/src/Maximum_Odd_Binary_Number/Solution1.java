package Maximum_Odd_Binary_Number;

public class Solution1 {
    public String maximumOddBinaryNumber(String s) {
        int one = 0;
        
        for(char ch: s.toCharArray()) {
        	if(ch == '1') {
        		one++;
        	}
        }
        
        int len = s.length();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<one-1;i++) {
        	sb.append(1);
        }
        
        for(int i=0;i<len-one;i++) {
        	sb.append(0);
        }
        
        return sb.append(1).toString();
    }
    
    public static void main(String[] args) {
    	Solution1 sol1 = new Solution1();
    	String s = "0101010";
    	
    	System.out.println("Output: " + sol1.maximumOddBinaryNumber(s));
	}
}