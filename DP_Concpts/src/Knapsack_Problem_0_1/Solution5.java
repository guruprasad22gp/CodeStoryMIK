package Knapsack_Problem_0_1;

public class Solution5 {
	int n;

	public int knapsack(int W, int val[], int wt[]) {
		n = val.length;
		return solve(n, W, val, wt);
	}

	private int solve(int i, int W, int[] val, int[] wt) {
		if (i == 0 || W == 0) {
			return 0;
		}

		int take = 0;
		if (wt[i - 1] <= W) {
			take = val[i - 1] + solve(i - 1, W - wt[i - 1], val, wt);
		}

		int skip = solve(i - 1, W, val, wt);
		return Math.max(take, skip);
	}

	public static void main(String[] args) {
		int W = 4;
		int[] val = { 1, 2, 3 };
		int wt[] = { 4, 5, 1 };

		Solution5 sol1 = new Solution5();
		System.out.println("Output: " + sol1.knapsack(W, val, wt));
	}
}