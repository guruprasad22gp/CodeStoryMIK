package Target_Sum;

public class Solution5 {
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
		return solve(n, target, nums);
	}

	private int solve(int i, int target, int[] nums) {
		if (i == 0) {
			return target == 0 ? 1 : 0;
		}

		int skip = solve(i - 1, target, nums);
		int take = 0;
		if (nums[i - 1] <= target) {
			take = solve(i - 1, target - nums[i - 1], nums);
		}

		return skip + take;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		int target = 3;
		Solution5 sol1 = new Solution5();
		System.out.println("Output: " + sol1.findTargetSumWays(nums, target));
	}
}