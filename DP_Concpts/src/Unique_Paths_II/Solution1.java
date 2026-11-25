package Unique_Paths_II;

public class Solution1 {
	int m;
	int n;

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		m = obstacleGrid.length;
		n = obstacleGrid[0].length;
		return solve(0, 0, obstacleGrid);
	}

	private int solve(int i, int j, int[][] arr) {
		if (i == m - 1 && j == n - 1) {
			return 1;
		}

		if (i >= m || j >= n || arr[i][j] == 1) {
			return 0;
		}

		return solve(i + 1, j, arr) + solve(i, j + 1, arr);
	}

	public static void main(String[] args) {
		int[][] nums = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.uniquePathsWithObstacles(nums));
	}
}
