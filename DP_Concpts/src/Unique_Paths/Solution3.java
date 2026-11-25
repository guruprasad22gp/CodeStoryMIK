package Unique_Paths;

public class Solution3 {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[i][n - 1] = 1;
		}

		for (int j = 0; j < n; j++) {
			dp[m - 1][j] = 1;
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
			}
		}

		return dp[0][0];
	}

	public static void main(String[] args) {
		int m = 4;
		int n = 4;

		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.uniquePaths(m, n));
	}
}
