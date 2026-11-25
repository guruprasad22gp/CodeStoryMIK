package Minimum_Operations_to_Make_Array_Values_Equal_to_K;

import java.util.HashSet;

public class Solution1 {
	public int minOperations(int[] nums, int k) {
		HashSet<Integer> set = new HashSet<>();
		for (int ele : nums) {
			if (ele < k) {
				return -1;
			}
			if (ele > k) {
				set.add(ele);
			}
		}

		return set.size();
	}

	public static void main(String[] args) {
		int[] nums = { 5, 2, 5, 4, 5 };
		int k = 2;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minOperations(nums, k));
	}
}