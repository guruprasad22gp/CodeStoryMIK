package Target_Sum;

public class Solution4 {
	public int findTargetSumWays(int[] nums, int target) {
		target = Math.abs(target);
		int sum = 0;
		for (int ele : nums) {
			sum += ele;
		}

		if ((sum + target) % 2 != 0) {
			return 0;
		}

		int n = nums.length;
		target = (sum + target) / 2;
		int[] prev = new int[target + 1];
		prev[0] = 1;

		for (int i = n - 1; i >= 0; i--) {
			int[] curr = new int[target + 1];
			for (int j = 0; j <= target; j++) {
				int skip = prev[j];
				int take = 0;
				if (nums[i] <= j) {
					take = prev[j - nums[i]];
				}
				curr[j] = take + skip;
			}
			prev = curr;
		}

		return prev[target];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		int target = 3;
		Solution4 sol1 = new Solution4();
		System.out.println("Output: " + sol1.findTargetSumWays(nums, target));
	}
}