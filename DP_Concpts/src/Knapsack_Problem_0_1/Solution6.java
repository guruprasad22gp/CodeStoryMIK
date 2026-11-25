package Knapsack_Problem_0_1;

import java.util.Arrays;

public class Solution6 {
	int n;
	int[][] dp;

	public int knapsack(int W, int val[], int wt[]) {
		n = val.length;
		dp = new int[n + 1][W + 1];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		return solve(n, W, val, wt);
	}

	private int solve(int i, int W, int[] val, int[] wt) {
		if (i == 0 || W == 0) {
			return 0;
		}

		if (dp[i][W] != -1) {
			return dp[i][W];
		}

		int take = 0;
		if (wt[i - 1] <= W) {
			take = val[i - 1] + solve(i - 1, W - wt[i - 1], val, wt);
		}
		int skip = solve(i - 1, W, val, wt);
		return dp[i][W] = Math.max(take, skip);
	}

	public static void main(String[] args) {
		int W = 4;
		int[] val = { 1, 2, 3 };
		int wt[] = { 4, 5, 1 };

		Solution6 sol1 = new Solution6();
		System.out.println("Output: " + sol1.knapsack(W, val, wt));
	}
}