package Build_Array_from_Permutation;

import java.util.Arrays;

public class Solution3 {
	public int[] buildArray(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			nums[i] = nums[i] + n * (nums[nums[i]] % n);
		}

		for (int i = 0; i < n; i++) {
			nums[i] = nums[i] / n;
		}
		return nums;
	}

	public static void main(String[] args) {
		int nums[] = { 0, 2, 1, 5, 3, 4 };
		Solution3 sol1 = new Solution3();
		int[] res = sol1.buildArray(nums);
		System.out.println("Output: " + Arrays.toString(res));
	}
}