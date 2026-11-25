package Divide_Array_Into_Equal_Pairs;

import java.util.Arrays;

public class Solution5 {
	public boolean divideArray(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i += 2) {
			int xor = nums[i] ^ nums[i - 1];
			if (xor != 0) {
				return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 3, 2, 2, 2 };
		Solution5 sol1 = new Solution5();
		System.out.println("Output: " + sol1.divideArray(nums));
	}
}
