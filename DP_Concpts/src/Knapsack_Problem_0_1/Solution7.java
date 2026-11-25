package Knapsack_Problem_0_1;

public class Solution7 {
	public int knapsack(int W, int val[], int wt[]) {
		int n = val.length;
		int[][] dp = new int[n + 1][W + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				int take = 0;
				if (wt[i - 1] <= j) {
					take = val[i - 1] + dp[i - 1][j - wt[i - 1]];
				}
				int skip = dp[i - 1][j];
				dp[i][j] = Math.max(take, skip);
			}
		}

		return dp[n][W];
	}

	public static void main(String[] args) {
		int W = 4;
		int[] val = { 1, 2, 3 };
		int wt[] = { 4, 5, 1 };

		Solution7 sol1 = new Solution7();
		System.out.println("Output: " + sol1.knapsack(W, val, wt));
	}
}