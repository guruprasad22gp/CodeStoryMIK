package Dungeon_Game;

public class Solution1 {
	int m;
	int n;

	public int calculateMinimumHP(int[][] dungeon) {
		m = dungeon.length;
		n = dungeon[0].length;

		int left = 1;
		int right = (int) 1e9;
		int minHealth = (int) 1e9;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (canSurvive(0, 0, mid, dungeon)) {
				minHealth = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return minHealth;
	}

	boolean canSurvive(int i, int j, int mid, int[][] arr) {
		if (i >= m || j >= n) {
			return false;
		}

		mid += arr[i][j];
		if (mid <= 0) {
			return false;
		}

		if (i == m - 1 && j == n - 1) {
			return true;
		}
		return canSurvive(i + 1, j, mid, arr) || canSurvive(i, j + 1, mid, arr);
	}

	public static void main(String[] args) {
		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.calculateMinimumHP(dungeon));
	}
}
