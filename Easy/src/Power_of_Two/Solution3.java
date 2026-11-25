package Power_of_Two;

public class Solution3 {
	public static void main(String[] args) {
		int n = 3;
		
		Solution3 sol3 = new Solution3();
		
		System.out.println("Output: " + sol3.isPowerOfTwo(n));
	}
	
    public boolean isPowerOfTwo(int n) {
    	if(n <= 0) {
    		return false;
    	}
    	    	
    	return Integer.bitCount(n) == 1;
    }
}
