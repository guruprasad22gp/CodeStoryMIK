package Power_of_Two;

public class Solution2 {
	public static void main(String[] args) {
		int n = 3;
		
		Solution2 sol2 = new Solution2();
		
		System.out.println("Output: " + sol2.isPowerOfTwo(n));
	}
	
    public boolean isPowerOfTwo(int n) {
    	if(n <= 0) {
    		return false;
    	}
    	return (n & n-1) == 0;
    }
}
