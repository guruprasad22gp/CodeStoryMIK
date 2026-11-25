package Count_Subsets_with_Sum;

import java.util.Arrays;

public class Solution6 {
	int[][] dp;

	public int perfectSum(int[] arr, int target) {
		dp = new int[arr.length + 1][target + 1];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		return solve(arr.length, target, arr);
	}

	private int solve(int i, int target, int[] arr) {
		if (i == 0) {
			return target == 0 ? 1 : 0;
		}

		if (target < 0) {
			return 0;
		}

		if (dp[i][target] != -1) {
			return dp[i][target];
		}
		int skip = solve(i - 1, target, arr);
		int take = solve(i - 1, target - arr[i - 1], arr);
		return dp[i][target] = skip + take;
	}

	public static void main(String[] args) {
		int arr[] = { 5, 2, 3, 10, 6, 8 };
		int target = 10;

		Solution6 sol1 = new Solution6();
		System.out.println("Output: " + sol1.perfectSum(arr, target));
	}
}