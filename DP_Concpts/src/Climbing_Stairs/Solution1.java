package Climbing_Stairs;

public class Solution1 {
    public int climbStairs(int n) {
    	return solve(n);
    }
    
    private int solve(int n) {
    	if(n <= 1) {
    		return 1;
    	}
    	
    	return solve(n-1) + solve(n-2);
    }

    public static void main(String[] args) {
		int n = 2;
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.climbStairs(n));
	}
}
