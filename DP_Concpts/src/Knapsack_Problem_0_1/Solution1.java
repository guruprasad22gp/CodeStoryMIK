package Knapsack_Problem_0_1;

public class Solution1 {
	int n;

	public int knapsack(int W, int val[], int wt[]) {
		n = val.length;
		return solve(0, W, val, wt);
	}

	private int solve(int i, int W, int[] val, int[] wt) {
		if (i >= n || W == 0) {
			return 0;
		}

		int skip = solve(i + 1, W, val, wt);
		int take = 0;
		if (wt[i] <= W) {
			take = val[i] + solve(i + 1, W - wt[i], val, wt);
		}
		return Math.max(take, skip);
	}

	public static void main(String[] args) {
		int W = 4;
		int[] val = { 1, 2, 3 };
		int wt[] = { 4, 5, 1 };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.knapsack(W, val, wt));
	}
}