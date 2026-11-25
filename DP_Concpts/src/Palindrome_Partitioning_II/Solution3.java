package Palindrome_Partitioning_II;

public class Solution3 {
	public int minCut(String s) {
		int n = s.length();

		int[][] dp = new int[n + 1][n + 1];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (i > j) {
					dp[i][j] = 0;
				} else if (palindrome(i, j, s)) {
					dp[i][j] = 0;
				} else {
					int result = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						int ans = 1 + dp[i][k] + dp[k + 1][j];
						result = Math.min(ans, result);
					}

					dp[i][j] = result;
				}
			}
		}

		return dp[0][n - 1];
	}

	private boolean palindrome(int i, int j, String s) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "guruprasad";

		Solution3 sol3 = new Solution3();
		System.out.println("Output: " + sol3.minCut(s));
	}
}
