package Divide_Array_Into_Equal_Pairs;

import java.util.Arrays;

public class Solution4 {
	public boolean divideArray(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i += 2) {
			if (nums[i] != nums[i - 1]) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 3, 2, 2, 2 };
		Solution4 sol1 = new Solution4();
		System.out.println("Output: " + sol1.divideArray(nums));
	}
}
