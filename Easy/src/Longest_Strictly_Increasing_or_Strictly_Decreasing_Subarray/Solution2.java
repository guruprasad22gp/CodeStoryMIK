package Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray;

public class Solution2 {
	public int longestMonotonicSubarray(int[] nums) {
		int n = nums.length;
		int max = 1;
		int currI = 1;
		int currD = 1;

		for (int i = 1; i < n; i++) {
			if (nums[i] < nums[i - 1]) {
				currD++;
				currI = 1;
			} else if (nums[i] > nums[i - 1]) {
				currD = 1;
				currI++;
			} else {
				currI = 1;
				currD = 1;
			}

			max = Math.max(max, Math.max(currD, currI));
		}

		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 4, 3, 3, 2, 5, 6 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.longestMonotonicSubarray(nums));
	}
}
