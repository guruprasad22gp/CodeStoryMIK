package Unique_Paths;

public class Solution4 {
	public int uniquePaths(int m, int n) {
		return solve(m - 1, n - 1);
	}

	private int solve(int i, int j) {
		if (i == 0 && j == 0) {
			return 1;
		}

		if (i < 0 || j < 0) {
			return 0;
		}

		return solve(i - 1, j) + solve(i, j - 1);
	}

	public static void main(String[] args) {
		int m = 4;
		int n = 4;

		Solution4 sol1 = new Solution4();
		System.out.println("Output: " + sol1.uniquePaths(m, n));
	}
}
