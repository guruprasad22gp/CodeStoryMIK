package ThreeSum_Closest;

import java.util.Arrays;

public class Solution2 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closest = 0;
		int diff = Integer.MAX_VALUE;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			int k = n - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				closest = Math.abs(sum - target) < diff ? sum : closest;
				diff = Math.min(diff, Math.abs(target - sum));

				if (sum < target) {
					j++;
				} else {
					k--;
				}
			}
		}

		return closest;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 12, 7, 8, -5 };
		int target = 16;
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.threeSumClosest(nums, target));
	}
}