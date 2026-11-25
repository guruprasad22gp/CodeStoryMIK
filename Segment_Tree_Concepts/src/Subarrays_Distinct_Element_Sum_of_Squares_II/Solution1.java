package Subarrays_Distinct_Element_Sum_of_Squares_II;

import java.util.TreeSet;

public class Solution1 {
	public int sumCounts(int[] nums) {
		int res = 0;
		int n = nums.length;
		int MOD = 1_000_000_007;
		for (int i = 0; i < n; i++) {
			TreeSet<Integer> set = new TreeSet<>();
			for (int j = i; j < n; j++) {
				set.add(nums[j]);
				int size = set.size();
				res = (res + (size * size) % MOD) % MOD;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.sumCounts(nums));
	}
}