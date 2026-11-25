package Build_Array_from_Permutation;

import java.util.Arrays;

public class Solution2 {
	public int[] buildArray(int[] nums) {
		solve(nums, 0);
		return nums;
	}

	private void solve(int[] nums, int i) {
		if (i < nums.length) {
			int res = nums[nums[i]];
			solve(nums, i + 1);
			nums[i] = res;
		}
	}

	public static void main(String[] args) {
		int nums[] = { 0, 2, 1, 5, 3, 4 };
		Solution2 sol1 = new Solution2();
		int[] res = sol1.buildArray(nums);
		System.out.println("Output: " + Arrays.toString(res));
	}
}