package Apply_Operations_to_an_Array;

import java.util.Arrays;

public class Solution1 {
	public int[] applyOperations(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				nums[i] = nums[i] * 2;
				nums[i + 1] = 0;
			}
		}

		int i = 0;
		int[] ans = new int[n];
		for (int ele : nums) {
			if (ele != 0) {
				ans[i++] = ele;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 1, 1, 0 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + Arrays.toString(sol1.applyOperations(nums)));
	}
}
