package Sliding_Window_Maximum;

import java.util.Arrays;

public class Solution1 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length - k + 1;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = i; j < i + k; j++) {
				max = Math.max(max, nums[j]);
			}
			res[i] = max;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;

		Solution1 sol1 = new Solution1();
		int[] res = sol1.maxSlidingWindow(nums, k);
		System.out.println("Output: " + Arrays.toString(res));
	}
}