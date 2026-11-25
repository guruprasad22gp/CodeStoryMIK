package Knapsack_Problem_0_1;

public class Solution8 {
	public int knapsack(int W, int val[], int wt[]) {
		int n = val.length;
		int[] prev = new int[W + 1];

		for (int i = 1; i <= n; i++) {
			int[] curr = new int[W + 1];
			for (int j = 0; j <= W; j++) {
				int take = 0;
				if (wt[i - 1] <= j) {
					take = val[i - 1] + prev[j - wt[i - 1]];
				}
				int skip = prev[j];

				curr[j] = Math.max(take, skip);
			}

			prev = curr;
		}

		return prev[W];
	}

	public static void main(String[] args) {
		int W = 4;
		int[] val = { 1, 2, 3 };
		int wt[] = { 4, 5, 1 };

		Solution8 sol1 = new Solution8();
		System.out.println("Output: " + sol1.knapsack(W, val, wt));
	}
}