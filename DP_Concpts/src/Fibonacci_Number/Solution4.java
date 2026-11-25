package Fibonacci_Number;

public class Solution4 {

	public int fib(int n) {
		if(n <= 1) {
			return n;
		}
		
		int prev2 = 0;
		int prev1 = 1;
		int result = prev1;
		for(int i=2;i<=n;i++) {
			result = prev1 + prev2;
			prev2 = prev1;
			prev1 = result;
		}
        return result;
    }
	
	public static void main(String[] args) {
		int n = 5;
		Solution4  sol4 = new Solution4();
		System.out.println("Output: " + sol4.fib(n));
	}
}
