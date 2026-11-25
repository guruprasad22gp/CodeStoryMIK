package Partitions_with_Given_Difference;

public class Solution8 {
	public int countPartitions(int[] arr, int diff) {
		int sum = 0;
		for (int ele : arr) {
			sum += ele;
		}

		if ((sum + diff) % 2 != 0) {
			return 0;
		}

		int target = (sum + diff) / 2;
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
		int arr[] = { 5, 2, 6, 4 };
		int diff = 3;

		Solution8 sol1 = new Solution8();
		System.out.println("Output: " + sol1.countPartitions(arr, diff));
	}
}
