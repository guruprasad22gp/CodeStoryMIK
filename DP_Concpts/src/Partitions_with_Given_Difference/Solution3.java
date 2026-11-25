package Partitions_with_Given_Difference;

import java.util.Arrays;

public class Solution3 {
	int[][] dp;

	public int countPartitions(int[] arr, int diff) {
		int sum = 0;
		for (int ele : arr) {
			sum += ele;
		}

		if ((sum + diff) % 2 != 0) {
			return 0;
		}
		int n = arr.length;
		int target = (sum + diff) / 2;
		dp = new int[n + 1][target + 1];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		return solve(0, target, arr);
	}

	private int solve(int i, int target, int[] arr) {
		if (i == arr.length) {
			return target == 0 ? 1 : 0;
		}

		if (dp[i][target] != -1) {
			return dp[i][target];
		}

		int skip = solve(i + 1, target, arr);
		int take = 0;
		if (arr[i] <= target) {
			take = solve(i + 1, target - arr[i], arr);
		}

		return dp[i][target] = skip + take;
	}

	public static void main(String[] args) {
		int arr[] = { 5, 2, 6, 4 };
		int diff = 3;

		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.countPartitions(arr, diff));
	}
}
