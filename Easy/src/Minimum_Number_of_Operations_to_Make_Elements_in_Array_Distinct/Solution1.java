package Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct;

import java.util.HashSet;

public class Solution1 {
	public int minimumOperations(int[] nums) {
		int n = nums.length;
		int operations = 0;
		for (int i = 0; i < n; i += 3) {
			if (check(i, nums)) {
				return operations;
			}
			operations++;
		}

		return operations;
	}

	boolean check(int i, int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return false;
			}
			set.add(nums[i]);
		}

		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 5, 7, 3 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minimumOperations(nums));
	}
}
