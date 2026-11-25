package Two_Sum;

import java.util.Arrays;

public class Solution1 {
	public int[] twoSum(int[] nums, int target) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + Arrays.toString(sol1.twoSum(nums, target)));
	}
}