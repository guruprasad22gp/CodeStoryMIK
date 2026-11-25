package Find_Missing_and_Repeated_Values;

import java.util.Arrays;

public class Solution1 {
	public int[] findMissingAndRepeatedValues(int[][] grid) {
		int n = grid.length;
		int[] arr = new int[n * n + 1];
		for (int[] x : grid) {
			for (int ele : x) {
				arr[ele]++;
			}
		}
		int[] res = new int[2];
		for (int i = 1; i <= n * n; i++) {
			if (arr[i] == 0) {
				res[1] = i;
			} else if (arr[i] == 2) {
				res[0] = i;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] grid = { { 9, 1, 7 }, { 8, 9, 2 }, { 3, 4, 6 } };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + Arrays.toString(sol1.findMissingAndRepeatedValues(grid)));
	}
}
