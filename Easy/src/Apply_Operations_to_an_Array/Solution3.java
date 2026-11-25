package Apply_Operations_to_an_Array;

import java.util.Arrays;

public class Solution3 {
	public int[] applyOperations(int[] nums) {
		int n = nums.length;
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (i + 1 < n && nums[i] == nums[i + 1]) {
				nums[i] = 2 * nums[i];
				nums[i + 1] = 0;
			}

			if (nums[i] != 0) {
				if (i != j) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
				j++;
			}
		}

		return nums;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 1, 1, 0 };
		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + Arrays.toString(sol1.applyOperations(nums)));
	}
}
