package Largest_Odd_Number_in_String;

public class Main {
    public String largestOddNumber(String num) {
        int n = num.length()-1;
        
        while(n >= 0) {
        	if((num.charAt(n) - '0') % 2 != 0) {
        		return num.substring(0, n+1);
        	}
        	
        	n--;
        }
        
        return "";
    }
    
    public static void main(String[] args) {
    	Main  m = new Main();
    	String num = "123456780";
    	
    	num = m.largestOddNumber(num);
    	
    	System.out.println("Output: " + num);
	}
}
