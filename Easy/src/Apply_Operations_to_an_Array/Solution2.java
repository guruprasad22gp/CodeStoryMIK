package Apply_Operations_to_an_Array;

import java.util.Arrays;

public class Solution2 {
	public int[] applyOperations(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				nums[i] = nums[i] * 2;
				nums[i + 1] = 0;
			}
		}

		int i = 0;
		int j = 0;
		while (i < n) {
			if (nums[i] != 0) {
				nums[j] = nums[i];
				j++;
			}
			i++;
		}

		while (j < n) {
			nums[j++] = 0;
		}

		return nums;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 1, 1, 0 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + Arrays.toString(sol1.applyOperations(nums)));
	}
}
