package Count_Subsets_with_Sum;

public class Solution7 {
	public int perfectSum(int[] arr, int target) {
		int n = arr.length;
		int[][] dp = new int[n + 1][target + 1];
		dp[0][0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= target; j++) {

				int skip = dp[i - 1][j];
				int take = 0;
				if (arr[i - 1] <= j) {
					take = dp[i - 1][j - arr[i - 1]];
				}
				dp[i][j] = skip + take;
			}
		}
		return dp[n][target];
	}

	public static void main(String[] args) {
		int arr[] = { 5, 2, 3, 10, 6, 8 };
		int target = 10;

		Solution7 sol1 = new Solution7();
		System.out.println("Output: " + sol1.perfectSum(arr, target));
	}
}