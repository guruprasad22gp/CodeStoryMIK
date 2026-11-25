package Count_Subsets_with_Sum;

public class Solution3 {
	int perfectSum(int[] arr, int target) {
		int n = arr.length;
		int[][] dp = new int[n + 1][target + 1];
		dp[n][0] = 1;

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= target; j++) {
				int skip = dp[i + 1][j];
				int take = 0;

				if (arr[i] <= j) {
					take = dp[i + 1][j - arr[i]];
				}
				dp[i][j] = skip + take;
			}
		}

		return dp[0][target];
	}

	public static void main(String[] args) {
		int arr[] = { 5, 7, 8 };
		int target = 15;

		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.perfectSum(arr, target));
	}
}