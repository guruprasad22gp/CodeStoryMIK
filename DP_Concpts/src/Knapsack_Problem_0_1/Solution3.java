package Knapsack_Problem_0_1;

public class Solution3 {
	public int knapsack(int W, int val[], int wt[]) {
		int n = val.length;
		int[][] dp = new int[n + 1][W + 1];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= W; j++) {
				int take = 0;
				if (wt[i] <= j) {
					take = val[i] + dp[i + 1][j - wt[i]];
				}

				int skip = dp[i + 1][j];

				dp[i][j] = Math.max(take, skip);
			}
		}

		return dp[0][W];

	}

	public static void main(String[] args) {
		int W = 4;
		int[] val = { 1, 2, 3 };
		int wt[] = { 4, 5, 1 };

		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.knapsack(W, val, wt));
	}
}