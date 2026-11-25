package Dungeon_Game;

public class Solution4 {
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] dp = new int[m][n];

		dp[m - 1][n - 1] = dungeon[m - 1][n - 1] <= 0 ? Math.abs(dungeon[m - 1][n - 1]) + 1 : 1;
		for (int i = m - 2; i >= 0; i--) {
			int ans = dp[i + 1][n - 1] - dungeon[i][n - 1];
			dp[i][n - 1] = ans <= 0 ? 1 : ans;
		}

		for (int j = n - 2; j >= 0; j--) {
			int ans = dp[m - 1][j] - dungeon[m - 1][j];
			dp[m - 1][j] = ans <= 0 ? 1 : ans;
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				int right = dp[i][j + 1];
				int down = dp[i + 1][j];
				int ans = Math.min(right, down) - dungeon[i][j];
				dp[i][j] = ans <= 0 ? 1 : ans;
			}
		}

//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.println(i + " " + j + " : " + dp[i][j]);
//			}
//		}

		return dp[0][0];
	}

	public static void main(String[] args) {
		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		Solution4 sol1 = new Solution4();
		System.out.println("Output: " + sol1.calculateMinimumHP(dungeon));
	}
}