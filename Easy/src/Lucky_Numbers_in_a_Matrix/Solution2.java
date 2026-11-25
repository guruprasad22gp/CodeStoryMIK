package Lucky_Numbers_in_a_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	public static void main(String[] args) {
		int[][] matrix = { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.luckyNumbers(matrix));
	}

	public List<Integer> luckyNumbers(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int rowMinMax = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			int rowMin = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				rowMin = Math.min(rowMin, matrix[i][j]);
			}
			rowMinMax = Math.max(rowMinMax, rowMin);
		}

		int colMaxMin = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int colMax = Integer.MIN_VALUE;
			for (int j = 0; j < m; j++) {
				colMax = Math.max(colMax, matrix[j][i]);
			}
			colMaxMin = Math.min(colMaxMin, colMax);
		}

		if (rowMinMax == colMaxMin) {
			List<Integer> re = new ArrayList<Integer>();
			re.add(rowMinMax);
			return re;
		}

		return new ArrayList<>();
	}
}