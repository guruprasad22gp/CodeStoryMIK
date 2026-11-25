package Unique_Paths_II;

import java.util.Arrays;

public class Solution2 {
	int m;
	int n;
	int[][] dp;

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		m = obstacleGrid.length;
		n = obstacleGrid[0].length;
		dp = new int[m][n];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}

		return solve(0, 0, obstacleGrid);
	}

	private int solve(int i, int j, int[][] arr) {
		if (i == m - 1 && j == n - 1) {
			return 1;
		}

		if (i >= m || j >= n || arr[i][j] == 1) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		return dp[i][j] = solve(i + 1, j, arr) + solve(i, j + 1, arr);
	}

	void print() {
		for (int[] x : dp) {
			System.out.println(Arrays.toString(x));
		}
	}

	public static void main(String[] args) {
		int[][] nums = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.uniquePathsWithObstacles(nums));
		sol1.print();
	}
}
