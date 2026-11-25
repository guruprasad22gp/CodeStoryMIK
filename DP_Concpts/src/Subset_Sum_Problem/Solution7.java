package Subset_Sum_Problem;

public class Solution7 {
	boolean isSubsetSum(int arr[], int sum) {
		int n = arr.length;
		boolean[][] dp = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				boolean take = false;
				if (arr[i - 1] <= j) {
					take |= dp[i - 1][j - arr[i - 1]];
				}
				boolean skip = dp[i - 1][j];
				dp[i][j] = skip | take;
			}
		}

		return dp[n][sum];

	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		int sum = 6;

		Solution7 sol1 = new Solution7();
		System.out.println("Output: " + sol1.isSubsetSum(arr, sum));
	}
}
