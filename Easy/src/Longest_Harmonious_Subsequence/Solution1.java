package Longest_Harmonious_Subsequence;

import java.util.Arrays;

public class Solution1 {
	public int findLHS(int[] nums) {
		Arrays.sort(nums);
		int maxLen = 0;
		int i = 0;
		int j = 1;
		while (j < nums.length) {
			while (i < j && nums[j] - nums[i] > 1) {
				i++;
			}
			if (nums[j] - nums[i] == 1) {
				maxLen = Math.max(maxLen, j - i + 1);
			}
			j++;
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.findLHS(nums));
	}
}
