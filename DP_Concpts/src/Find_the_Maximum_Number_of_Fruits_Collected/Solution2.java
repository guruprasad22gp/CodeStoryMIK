package Find_the_Maximum_Number_of_Fruits_Collected;

import java.util.Arrays;

public class Solution2 {
	int n;
	int[][] dp1;
	int[][] dp2;

	public int maxCollectedFruits(int[][] fruits) {
		n = fruits.length;

		int c1 = child1(fruits);

		dp1 = new int[n][n];
		for (int[] x : dp1) {
			Arrays.fill(x, -1);
		}
		int c2 = child2(0, n - 1, fruits);

		dp2 = new int[n][n];
		for (int[] x : dp2) {
			Arrays.fill(x, -1);
		}
		int c3 = child3(n - 1, 0, fruits);

		return c1 + c2 + c3;
	}

	private int child1(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i][i];
			arr[i][i] = 0;
		}

		return sum;
	}

	private int child2(int i, int j, int[][] arr) {
		if (i >= n || j >= n || i >= j || (i == n - 1 && j == n - 1)) {
			return 0;
		}

		if (dp1[i][j] != -1) {
			return dp1[i][j];
		}

		return dp1[i][j] = arr[i][j]
				+ Math.max(child2(i + 1, j - 1, arr), Math.max(child2(i + 1, j, arr), child2(i + 1, j + 1, arr)));
	}

	private int child3(int i, int j, int[][] arr) {
		if (i >= n || j >= n || i <= j || (i == n - 1 && j == n - 1)) {
			return 0;
		}

		if (dp2[i][j] != -1) {
			return dp1[i][j];
		}

		return dp1[i][j] = arr[i][j]
				+ Math.max(child3(i - 1, j + 1, arr), Math.max(child3(i, j + 1, arr), child3(i + 1, j + 1, arr)));
	}

	public static void main(String[] args) {
		int[][] fruits = { { 1, 2, 3, 4 }, { 5, 6, 8, 7 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		Solution2 sol1 = new Solution2();
		System.out.println("Output; " + sol1.maxCollectedFruits(fruits));
	}
}
