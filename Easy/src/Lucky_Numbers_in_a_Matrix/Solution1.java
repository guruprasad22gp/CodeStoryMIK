package Lucky_Numbers_in_a_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	public static void main(String[] args) {
		int[][] matrix = { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.luckyNumbers(matrix));
	}

	public List<Integer> luckyNumbers(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int rowMin[] = new int[m];
		for (int i = 0; i < m; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				min = Math.min(min, matrix[i][j]);
			}
			rowMin[i] = min;
		}

		int colMax[] = new int[n];
		for (int i = 0; i < n; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < m; j++) {
				max = Math.max(max, matrix[j][i]);
			}
			colMax[i] = max;
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) {
					result.add(rowMin[i]);
				}
			}
		}

		return result;
	}
}
