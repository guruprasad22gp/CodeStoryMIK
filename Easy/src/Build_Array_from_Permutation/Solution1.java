package Build_Array_from_Permutation;

import java.util.Arrays;

public class Solution1 {
	public int[] buildArray(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = nums[nums[i]];
		}
		return res;
	}

	public static void main(String[] args) {
		int nums[] = { 0, 2, 1, 5, 3, 4 };
		Solution1 sol1 = new Solution1();
		int[] res = sol1.buildArray(nums);
		System.out.println("Output: " + Arrays.toString(res));
	}
}