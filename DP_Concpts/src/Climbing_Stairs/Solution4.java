package Climbing_Stairs;

public class Solution4 {
    public int climbStairs(int n) {
    	if(n <= 0) {
    		return 0;
    	}
    	
    	if(n == 1) {
    		return 1;
    	}
    	
    	int first = 1;
    	int second = 1;
    	int result = first;
    	for(int i=2;i<=n;i++) {
    		result = first + second;
    		second = first;
    		first = result;
    	}
    	
    	return result;
    }

    public static void main(String[] args) { 
		int n = 10;
		
		Solution4 sol4 = new Solution4();
		System.out.println("Output: " + sol4.climbStairs(n));
	}
}
