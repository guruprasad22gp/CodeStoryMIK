package Maximum_Non_Negative_Product_in_a_Matrix;

public class Solution2 {
	int m;
	int n;
	Pair[][] dp;
	int MOD = 1_000_000_007;

	public int maxProductPath(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		dp = new Pair[m][n];

		Pair res = solve(0, 0, grid);
		return res.max >= 0 ? (int) (res.max % MOD) : -1;
	}

	private Pair solve(int i, int j, int[][] grid) {
		if (i == m - 1 && j == n - 1) {
			return new Pair(grid[i][j], grid[i][j]);
		}

		if (i >= m || j >= n) {
			return null;
		}

		if (dp[i][j] != null) {
			return dp[i][j];
		}

		long minVal = Long.MAX_VALUE;
		long maxVal = Long.MIN_VALUE;

		int ele = grid[i][j];
		Pair right = solve(i, j + 1, grid);
		if (right != null) {
			minVal = Math.min(minVal, Math.min(ele * right.min, ele * right.max));
			maxVal = Math.max(maxVal, Math.max(ele * right.min, ele * right.max));
		}

		Pair down = solve(i + 1, j, grid);
		if (down != null) {
			minVal = Math.min(minVal, Math.min(ele * down.min, ele * down.max));
			maxVal = Math.max(maxVal, Math.max(ele * down.min, ele * down.max));
		}

		return dp[i][j] = new Pair(minVal, maxVal);
	}

	void print() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] == null) {
					System.out.println(i + " " + j + " : ");
					continue;
				}
				System.out.println(i + " " + j + " : " + dp[i][j].min + " " + dp[i][j].max);
			}
		}
	}

	public static void main(String[] args) {
//		int[][] grid = { { 1, -2, 1 }, { 1, -2, 1 }, { 3, -4, 1 } };
		int[][] grid = { { -1, -2, 3, -3, -3, 3, 1, 0, 4, 1, 4, -3, 2, 3, -2 },
				{ -4, 0, 4, 4, 1, 1, 0, -2, -4, 1, 4, 1, -1, -4, 2 },
				{ -3, -2, 2, -4, -1, -1, -2, 0, 0, -1, -4, 2, 4, -2, 0 },
				{ 2, 2, 3, 3, -2, 4, -3, -3, 3, -4, 0, -1, 4, 4, 4 },
				{ -4, 0, -3, -2, -3, -2, 2, -1, 2, 4, 3, 4, -4, -3, -1 },
				{ -4, 0, -3, 0, 2, 2, 0, 3, 3, -1, 3, 3, 1, -3, -3 },
				{ -1, -3, 4, 3, 4, -2, -3, -3, -4, -3, 0, 2, -4, 4, -4 },
				{ 3, -1, 3, -4, -1, 1, 0, -3, 2, 1, -4, -2, 3, 0, 3 },
				{ 3, -1, -2, 2, -4, 4, -1, 3, -3, 2, -4, 0, -2, -2, 1 },
				{ 4, 1, -3, 2, -1, 2, 4, 0, 3, 4, 3, 2, 2, 3, 2 },
				{ -2, 1, 0, 3, -3, -4, -4, 4, 1, -2, -1, 3, 3, -3, 3 },
				{ 0, -2, 0, 2, 2, -3, -4, 2, 1, 2, -2, 0, -1, -3, 4 },
				{ 4, -1, -2, 3, 2, -1, -4, -4, 2, -3, 1, 0, 0, 4, -3 },
				{ -4, 2, -1, 4, 4, -2, -4, 4, -1, 1, -4, -3, -4, 3, 0 },
				{ 2, -1, -4, -2, 0, -3, 3, -4, 2, 0, 2, -3, 0, -3, 4 } };
		Solution2 sol1 = new Solution2();
		System.out.println("Output; " + sol1.maxProductPath(grid));
		sol1.print();
	}
}
