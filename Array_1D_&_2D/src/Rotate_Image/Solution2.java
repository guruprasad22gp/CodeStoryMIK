package Rotate_Image;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		Solution2 sol1 = new Solution2();
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
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			int left = 0;
			int right = n - 1;

			while (left < right) {
				int temp = matrix[i][left];
				matrix[i][left] = matrix[i][right];
				matrix[i][right] = temp;
				left++;
				right--;
			}
		}
	}
}