package Fibonacci_Number;

public class Solution3 {

	public int fib(int n) {
		if(n <= 1) {
			return n;
		}
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
        return dp[n];
    }
	
	public static void main(String[] args) {
		int n = 10;
		Solution3  sol3 = new Solution3();
		System.out.println("Output: " + sol3.fib(n));
	}
}
