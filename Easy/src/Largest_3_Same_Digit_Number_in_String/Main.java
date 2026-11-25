package Largest_3_Same_Digit_Number_in_String;

public class Main {
	public String largestGoodInteger(String num) {
        int max = -1;
        
        for(int i=1;i<num.length()-1;i++) {
        	if(num.charAt(i) == num.charAt(i-1) && num.charAt(i) == num.charAt(i+1)) {
        		if(num.charAt(i) - '0' > max) {
        			max = num.charAt(i) - '0';
        		}
        	}
        }
        
        if(max != -1) {
        	StringBuilder sb = new StringBuilder();
        	sb.append(max).append(max).append(max);
        	return sb.toString();
        }
        
        return "";
    }
	
	public static void main(String[] args) {
		String num ="44423523338";
		Main m = new Main();
		System.out.println("Output: " + m.largestGoodInteger(num));
	}
}
