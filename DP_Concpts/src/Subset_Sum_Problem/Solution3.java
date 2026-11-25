package Subset_Sum_Problem;

public class Solution3 {
	boolean isSubsetSum(int arr[], int sum) {
		int n = arr.length;
		boolean[][] dp = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= sum; j++) {
				boolean take = false;
				if (arr[i] <= j) {
					take |= dp[i + 1][j - arr[i]];
				}
				boolean skip = dp[i + 1][j];
				dp[i][j] = skip | take;
			}
		}

		return dp[0][sum];
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		int sum = 6;

		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.isSubsetSum(arr, sum));
	}
}
