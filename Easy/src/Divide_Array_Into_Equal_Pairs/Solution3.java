package Divide_Array_Into_Equal_Pairs;

import java.util.Arrays;

public class Solution3 {
	public boolean divideArray(int[] nums) {
		boolean[] arr = new boolean[501];
		Arrays.fill(arr, true);
		for (int ele : nums) {
			arr[ele] = !arr[ele];
		}

		for (boolean ele : arr) {
			if (!ele) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 3, 2, 2, 2 };
		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.divideArray(nums));
	}
}
