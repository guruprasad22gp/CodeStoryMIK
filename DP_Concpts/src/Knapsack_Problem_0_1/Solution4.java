package Knapsack_Problem_0_1;

public class Solution4 {
	public int knapsack(int W, int val[], int wt[]) {
		int n = val.length;
		int[] prev = new int[W + 1];

		for (int i = n - 1; i >= 0; i--) {
			int[] curr = new int[W + 1];
			for (int j = 0; j <= W; j++) {
				int take = 0;
				if (wt[i] <= j) {
					take = val[i] + prev[j - wt[i]];
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

		Solution4 sol1 = new Solution4();
		System.out.println("Output: " + sol1.knapsack(W, val, wt));
	}
}