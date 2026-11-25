package Convert_1D_Array_Into_2D_Array;

public class Solution1 {
	public int[][] construct2DArray(int[] original, int m, int n) {
		int len = original.length;

		if (len < m * n) {
			return new int[][] {};
		}

		int[][] res = new int[m][n];
		int k = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = original[k++];
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4 };
		int m = 2;
		int n = 2;

		Solution1 sol1 = new Solution1();
		int[][] res = sol1.construct2DArray(original, m, n);

		for (int x[] : res) {
			for (int ele : x) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}

	}
}
