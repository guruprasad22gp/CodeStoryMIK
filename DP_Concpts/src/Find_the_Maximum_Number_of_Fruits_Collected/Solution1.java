package Find_the_Maximum_Number_of_Fruits_Collected;

public class Solution1 {
	int n;

	public int maxCollectedFruits(int[][] fruits) {
		n = fruits[0].length;
		int c1 = child1(fruits);
		int c2 = child2(0, n - 1, fruits);
		int c3 = child3(n - 1, 0, fruits);

		System.out.println(c1 + " " + c2 + " " + c3);
		return c1 + c2 + c3;
	}

	private int child1(int[][] fruits) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += fruits[i][i];
			fruits[i][i] = 0;
		}
		return sum;
	}

	private int child2(int i, int j, int[][] fruits) {
		if (i >= j || i >= n || j >= n || (i == n - 1 && j == n - 1)) {
			return 0;
		}

		return fruits[i][j] + Math.max(child2(i + 1, j - 1, fruits),
				Math.max(child2(i + 1, j, fruits), child2(i + 1, j + 1, fruits)));
	}

	private int child3(int i, int j, int[][] fruits) {
		if (i <= j || i >= n || j >= n || (i == n - 1 && j == n - 1)) {
			return 0;
		}

		return fruits[i][j] + Math.max(child3(i - 1, j + 1, fruits),
				Math.max(child3(i, j + 1, fruits), child3(i + 1, j + 1, fruits)));
	}

	public static void main(String[] args) {
		int[][] fruits = { { 1, 2, 3, 4 }, { 5, 6, 8, 7 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		Solution1 sol1 = new Solution1();
		System.out.println("Output; " + sol1.maxCollectedFruits(fruits));
	}
}
