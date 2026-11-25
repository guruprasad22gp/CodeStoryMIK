package Dungeon_Game;

public class Solution2 {
	int m;
	int n;

	public int calculateMinimumHP(int[][] dungeon) {
		m = dungeon.length;
		n = dungeon[0].length;
		return solve(0, 0, dungeon);
	}

	private int solve(int i, int j, int[][] arr) {
		if (i == m - 1 && j == n - 1) {
			int returnVal = arr[i][j] <= 0 ? Math.abs(arr[i][j]) : 0;
			return returnVal + 1;
		}

		if (i >= m || j >= n) {
			return Integer.MAX_VALUE;
		}

		int right = solve(i, j + 1, arr);
		int down = solve(i + 1, j, arr);
		int ans = Math.min(right, down) - arr[i][j];

		return ans <= 0 ? 1 : ans;

	}

	public static void main(String[] args) {
		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.calculateMinimumHP(dungeon));
	}
}