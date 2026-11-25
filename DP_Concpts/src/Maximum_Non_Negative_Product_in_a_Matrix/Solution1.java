package Maximum_Non_Negative_Product_in_a_Matrix;

class Pair {
	long min;
	long max;

	Pair(long min, long max) {
		this.min = min;
		this.max = max;
	}
}

public class Solution1 {
	int m;
	int n;
	int MOD = 1_000_000_007;

	public int maxProductPath(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
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

		long maxVal = Long.MIN_VALUE;
		long minVal = Long.MAX_VALUE;

		Pair right = solve(i, j + 1, grid);
		if (right != null) {
			maxVal = Math.max(maxVal, Math.max(right.min * grid[i][j], right.max * grid[i][j]));
			minVal = Math.min(Math.min(right.min * grid[i][j], right.max * grid[i][j]), minVal);
		}

		Pair down = solve(i + 1, j, grid);
		if (down != null) {
			maxVal = Math.max(maxVal, Math.max(down.min * grid[i][j], down.max * grid[i][j]));
			minVal = Math.min(Math.min(down.min * grid[i][j], down.max * grid[i][j]), minVal);
		}

		return new Pair(minVal, maxVal);
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

		Solution1 sol1 = new Solution1();
		System.out.println("Output; " + sol1.maxProductPath(grid));
	}
}
