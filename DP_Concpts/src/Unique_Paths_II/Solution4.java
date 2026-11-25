package Unique_Paths_II;

public class Solution4 {
	int m;
	int n;

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		m = obstacleGrid.length;
		n = obstacleGrid[0].length;
		return solve(m - 1, n - 1, obstacleGrid);
	}

	private int solve(int i, int j, int[][] arr) {
		if (i == 0 && j == 0 && arr[i][j] == 0) {
			return 1;
		}

		if (i < 0 || j < 0 || arr[i][j] == 1) {
			return 0;
		}

		return solve(i - 1, j, arr) + solve(i, j - 1, arr);
	}

	public static void main(String[] args) {
		int[][] nums = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

		Solution4 sol1 = new Solution4();
		System.out.println("Output: " + sol1.uniquePathsWithObstacles(nums));
	}
}
