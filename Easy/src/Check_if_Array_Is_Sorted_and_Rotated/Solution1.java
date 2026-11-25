package Check_if_Array_Is_Sorted_and_Rotated;

import java.util.Arrays;

public class Solution1 {
	public boolean check(int[] nums) {
		int n = nums.length;
		int[] sorted = Arrays.copyOf(nums, n);
		Arrays.sort(sorted);
		for (int i = 0; i <= n; i++) {
			int idx = 0;
			int[] arr = new int[n];
			for (int j = i; j < n; j++) {
				arr[idx++] = nums[j];
			}

			for (int j = 0; j < i; j++) {
				arr[idx++] = nums[j];
			}

			if (Arrays.compare(arr, sorted) == 0) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 5, 1, 2 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.check(nums));
	}
}