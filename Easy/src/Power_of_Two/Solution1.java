package Power_of_Two;

public class Solution1 {
	public static void main(String[] args) {
		int n = 16;
		
		Solution1 sol1 = new Solution1();
		
		System.out.println("Output: " + sol1.isPowerOfTwo(n));
	}
	
    public boolean isPowerOfTwo(int n) {
    	if(n <= 0) {
    		return false;
    	}
    	
    	if(n == 1) {
    		return true;
    	}
    	
    	
    	int rem = 0;
    	
    	while(n > 0) {
    		rem = n % 2;
    		
    		if(n > 2 && rem != 0) {
    			return false;
    		}
    		
    		n /= 2;
    	}
    	
    	return true;
    }
}
