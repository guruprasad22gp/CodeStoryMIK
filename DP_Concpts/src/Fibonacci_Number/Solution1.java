package Fibonacci_Number;

public class Solution1 {
	public int fib(int n) {
        return solve(n);
    }
	
	private int solve(int n) {
		if(n <= 1) {
			return n;
		}
		
		return solve(n-1) + solve(n-2);
	}
	
	public static void main(String[] args) {
		int n = 5;
		Solution1  sol1 = new Solution1();
		System.out.println("Output: " + sol1.fib(n));
	}
}
