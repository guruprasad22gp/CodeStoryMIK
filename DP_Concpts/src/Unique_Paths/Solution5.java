package Unique_Paths;

import java.util.Arrays;

public class Solution5 {
	int[][] dp;

	public int uniquePaths(int m, int n) {
		dp = new int[m][n];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}

		return solve(m - 1, n - 1);
	}

	private int solve(int i, int j) {
		if (i == 0 && j == 0) {
			return 1;
		}

		if (i < 0 || j < 0) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		return dp[i][j] = solve(i - 1, j) + solve(i, j - 1);
	}

	public static void main(String[] args) {
		int m = 5;
		int n = 5;

		Solution5 sol1 = new Solution5();
		System.out.println("Output: " + sol1.uniquePaths(m, n));
	}
}
