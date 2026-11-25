package Convert_1D_Array_Into_2D_Array;

public class Solution2 {
	public int[][] construct2DArray(int[] original, int m, int n) {
		if (m * n != original.length) {
			return new int[][] {};
		}
		int[][] res = new int[m][n];
		for (int i = 0; i < original.length; i++) {
			int row = i / n;
			int col = i % n;
			res[row][col] = original[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4 };
		int m = 2;
		int n = 2;

		Solution2 sol1 = new Solution2();
		int[][] res = sol1.construct2DArray(original, m, n);

		for (int x[] : res) {
			for (int ele : x) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}

	}
}
