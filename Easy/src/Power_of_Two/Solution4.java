package Power_of_Two;

public class Solution4 {
	public static void main(String[] args) {
		int n = 3;
		
		Solution4 sol4 = new Solution4();
		
		System.out.println("Output: " + sol4.isPowerOfTwo(n));
	}
	
    public boolean isPowerOfTwo(int n) {
    	if(n <= 0) {
    		return false;
    	}
    	
    	return 1073741824 % n == 0;
    }
}
