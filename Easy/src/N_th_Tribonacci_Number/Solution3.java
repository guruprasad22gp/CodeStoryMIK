package N_th_Tribonacci_Number;

public class Solution3 {
    public int tribonacci(int n) {
        if(n == 0) {
            return  0;
        } else if(n == 1 || n == 2) {
            return 1;
        }
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;
        
        for(int i=3;i<=n;i++) {
        	dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
		int n = 25;
		Solution3 sol3 = new Solution3();
		System.out.println("Output: " + sol3.tribonacci(n));
	}
}
