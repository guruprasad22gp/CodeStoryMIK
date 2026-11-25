package Partition_Equal_Subset_Sum;

import java.util.Arrays;

public class Solution2 {
	int n;
	int[][] dp;

	public boolean canPartition(int[] nums) {
		n = nums.length;
		int sum = 0;
		for (int ele : nums) {
			sum += ele;
		}

		if (sum % 2 == 1) {
			return false;
		}

		sum /= 2;

		dp = new int[n][sum + 1];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}

		return solve(0, sum, nums);
	}

	private boolean solve(int i, int sum, int[] arr) {
		if (sum == 0) {
			return true;
		}

		if (i >= n) {
			return false;
		}

		if (dp[i][sum] != -1) {
			return dp[i][sum] == 1 ? true : false;
		}

		boolean take = false;
		if (arr[i] <= sum) {
			take |= solve(i + 1, sum - arr[i], arr);
		}

		boolean skip = solve(i + 1, sum, arr);
		dp[i][sum] = skip | take ? 1 : 0;
		return skip | take;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 11, 5 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.canPartition(arr));
	}
}