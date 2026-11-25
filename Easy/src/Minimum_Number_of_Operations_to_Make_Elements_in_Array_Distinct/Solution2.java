package Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct;

import java.util.HashSet;

public class Solution2 {
	public int minimumOperations(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			if (set.contains(nums[i])) {
				return (int) Math.ceil((i + 1) / 3.0);
			}
			set.add(nums[i]);
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 5, 7 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.minimumOperations(nums));
	}
}