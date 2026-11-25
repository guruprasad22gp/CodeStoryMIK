package Maximum_Non_Negative_Product_in_a_Matrix;

public class Solution3 {
	public int maxProductPath(int[][] grid) {
		int MOD = 1_000_000_007;
		int m = grid.length;
		int n = grid[0].length;
		Pair[][] dp = new Pair[m][n];

		dp[m - 1][n - 1] = new Pair(grid[m - 1][n - 1], grid[m - 1][n - 1]);

		for (int i = m - 2; i >= 0; i--) {
			int ele = grid[i][n - 1];
			dp[i][n - 1] = new Pair(dp[i + 1][n - 1].min * ele, dp[i + 1][n - 1].max * ele);
		}

		for (int j = n - 2; j >= 0; j--) {
			int ele = grid[m - 1][j];
			dp[m - 1][j] = new Pair(dp[m - 1][j + 1].min * ele, dp[m - 1][j + 1].max * ele);
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				long minVal = Long.MAX_VALUE;
				long maxVal = Long.MIN_VALUE;

				long ele = grid[i][j];
				Pair right = dp[i][j + 1];
				if (right != null) {
					minVal = Math.min(minVal, Math.min(ele * right.min, ele * right.max));
					maxVal = Math.max(maxVal, Math.max(ele * right.min, ele * right.max));
				}

				Pair down = dp[i + 1][j];
				if (down != null) {
					minVal = Math.min(minVal, Math.min(ele * down.min, ele * down.max));
					maxVal = Math.max(maxVal, Math.max(ele * down.min, ele * down.max));
				}

				dp[i][j] = new Pair(minVal, maxVal);
			}
		}

//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				if (dp[i][j] == null) {
//					System.out.println(i + " " + j);
//					continue;
//				}
//				System.out.println(i + " " + j + " : " + dp[i][j].min + " " + dp[i][j].max);
//			}
//		}
		Pair res = dp[0][0];
		return res.max >= 0 ? (int) (res.max % MOD) : -1;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, -2, 1 }, { 1, -2, 1 }, { 3, -4, 1 } };
//		int[][] grid = { { -1, -2, 3, -3, -3, 3, 1, 0, 4, 1, 4, -3, 2, 3, -2 },
//				{ -4, 0, 4, 4, 1, 1, 0, -2, -4, 1, 4, 1, -1, -4, 2 },
//				{ -3, -2, 2, -4, -1, -1, -2, 0, 0, -1, -4, 2, 4, -2, 0 },
//				{ 2, 2, 3, 3, -2, 4, -3, -3, 3, -4, 0, -1, 4, 4, 4 },
//				{ -4, 0, -3, -2, -3, -2, 2, -1, 2, 4, 3, 4, -4, -3, -1 },
//				{ -4, 0, -3, 0, 2, 2, 0, 3, 3, -1, 3, 3, 1, -3, -3 },
//				{ -1, -3, 4, 3, 4, -2, -3, -3, -4, -3, 0, 2, -4, 4, -4 },
//				{ 3, -1, 3, -4, -1, 1, 0, -3, 2, 1, -4, -2, 3, 0, 3 },
//				{ 3, -1, -2, 2, -4, 4, -1, 3, -3, 2, -4, 0, -2, -2, 1 },
//				{ 4, 1, -3, 2, -1, 2, 4, 0, 3, 4, 3, 2, 2, 3, 2 },
//				{ -2, 1, 0, 3, -3, -4, -4, 4, 1, -2, -1, 3, 3, -3, 3 },
//				{ 0, -2, 0, 2, 2, -3, -4, 2, 1, 2, -2, 0, -1, -3, 4 },
//				{ 4, -1, -2, 3, 2, -1, -4, -4, 2, -3, 1, 0, 0, 4, -3 },
//				{ -4, 2, -1, 4, 4, -2, -4, 4, -1, 1, -4, -3, -4, 3, 0 },
//				{ 2, -1, -4, -2, 0, -3, 3, -4, 2, 0, 2, -3, 0, -3, 4 } };
		Solution3 sol1 = new Solution3();
		System.out.println("Output; " + sol1.maxProductPath(grid));
	}
}