package Find_the_Maximum_Number_of_Fruits_Collected;

public class Solution3 {
	public int maxCollectedFruits(int[][] fruits) {
		int n = fruits.length;

		int c1 = 0;
		for (int i = 0; i < n; i++) {
			c1 += fruits[i][i];
		}

		int[][] dp1 = new int[n][n];
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				int max = Math.max(dp1[i + 1][j - 1], dp1[i + 1][j]);
				if (j + 1 < n) {
					max = Math.max(max, dp1[i + 1][j + 1]);
				}
				dp1[i][j] = fruits[i][j] + max;
			}
		}

		int[][] dp2 = new int[n][n];
		for (int j = n - 2; j >= 0; j--) {
			for (int i = j + 1; i < n; i++) {
				int max = Math.max(dp2[i - 1][j + 1], dp2[i][j + 1]);
				if (i + 1 < n) {
					max = Math.max(max, dp2[i + 1][j + 1]);
				}
				dp2[i][j] = max + fruits[i][j];
			}
		}

		return c1 + dp1[0][n - 1] + dp2[n - 1][0];
	}

	public static void main(String[] args) {
		int[][] fruits = { { 1, 2, 3, 4 }, { 5, 6, 8, 7 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		Solution3 sol1 = new Solution3();
		System.out.println("Output; " + sol1.maxCollectedFruits(fruits));
	}
}
