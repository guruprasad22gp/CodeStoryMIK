package Rotate_Image;

import java.util.Arrays;

public class Solution1 {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		Solution1 sol1 = new Solution1();
		System.out.println("Before: ");
		for (int[] x : matrix) {
			System.out.println(Arrays.toString(x));
		}

		sol1.rotate(matrix);
		System.out.println("After: ");
		for (int[] x : matrix) {
			System.out.println(Arrays.toString(x));
		}
	}

	public void rotate(int[][] matrix) {
		int n = matrix.length;

		int[][] res = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				res[j][n - i - 1] = matrix[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = res[i][j];
			}
		}

	}
}
