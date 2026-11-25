package N_th_Tribonacci_Number;

import java.util.Arrays;

public class Solution2 {
	int[] dp;
    public int tribonacci(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return solve(n);
    }
    
    private int solve(int n) {
    	if(n <= 1) {
    		return n;
    	} else if(n == 2) {
    		return 1;
    	}
    	
    	if(dp[n] != -1) {
    		return dp[n];
    	}
    	
    	return dp[n] = solve(n-1) + solve(n-2) + solve(n-3);
    }
    
    public static void main(String[] args) {
		int n = 4;
		
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.tribonacci(n));
	}
}
