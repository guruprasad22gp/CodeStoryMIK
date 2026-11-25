package Unique_Paths;

public class Solution1 {
	public int uniquePaths(int m, int n) {
		return solve(0, 0, m, n);
	}

	private int solve(int i, int j, int m, int n) {
		if (i == m - 1 && j == n - 1) {
			return 1;
		}

		if (i >= m || j >= n) {
			return 0;
		}

		return solve(i + 1, j, m, n) + solve(i, j + 1, m, n);
	}

	public static void main(String[] args) {
		int m = 4;
		int n = 4;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.uniquePaths(m, n));
	}
}
