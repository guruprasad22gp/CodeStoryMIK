package Fractional_Knapsack;

import java.util.Arrays;

public class Solution1 {
	public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
		int n = val.length;
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = val[i];
			arr[i][1] = wt[i];
		}

		Arrays.sort(arr, (a, b) -> {
			return Double.compare((double) b[0] / b[1], (double) a[0] / a[1]);
		});

		for (int[] x : arr) {
			System.out.println(x[0] + " " + x[1]);
		}

		double total = 0;
		for (int i = 0; i < n; i++) {
			if (capacity >= arr[i][1]) {
				total += arr[i][0];
				capacity -= arr[i][1];
			} else {
				total += ((double) arr[i][0] / arr[i][1]) * capacity;
				capacity = 0;
				break;
			}
		}
		return total;

	}

	public static void main(String[] args) {
		int val[] = { 8, 2, 10, 1, 9, 7, 2, 6, 4, 9 };
		int wt[] = { 10, 1, 7, 7, 5, 1, 8, 6, 8, 7 };
		int capacity = 21;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.fractionalKnapsack(val, wt, capacity));
	}
}
