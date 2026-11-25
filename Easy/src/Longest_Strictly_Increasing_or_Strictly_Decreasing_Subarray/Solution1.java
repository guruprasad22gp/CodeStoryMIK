package Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray;

public class Solution1 {
	public int longestMonotonicSubarray(int[] nums) {
		int max = 0;
		int curr = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			curr = 1;
			for (int j = i + 1; j < n; j++) {
				if (nums[j] > nums[j - 1]) {
					curr++;
				} else {
					break;
				}
			}

			max = Math.max(max, curr);
		}

		for (int i = 0; i < n; i++) {
			curr = 1;
			for (int j = i + 1; j < n; j++) {
				if (nums[j] < nums[j - 1]) {
					curr++;
				} else {
					break;
				}
			}

			max = Math.max(max, curr);
		}

		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 4, 3, 3, 2, 5, 6 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.longestMonotonicSubarray(nums));
	}
}
