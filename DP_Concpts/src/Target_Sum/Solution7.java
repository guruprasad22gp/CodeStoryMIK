package Target_Sum;

public class Solution7 {
	public int findTargetSumWays(int[] nums, int target) {
		target = Math.abs(target);
		int sum = 0;
		for (int ele : nums) {
			sum += ele;
		}

		if ((sum + target) % 2 != 0) {
			return 0;
		}

		target = (sum + target) / 2;
		int n = nums.length;
		int[][] dp = new int[n + 1][target + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= target; j++) {
				int skip = dp[i - 1][j];
				int take = 0;
				if (nums[i - 1] <= j) {
					take = dp[i - 1][j - nums[i - 1]];
				}

				dp[i][j] = skip + take;
			}
		}
		return dp[n][target];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		int target = 3;
		Solution7 sol1 = new Solution7();
		System.out.println("Output: " + sol1.findTargetSumWays(nums, target));
	}
}