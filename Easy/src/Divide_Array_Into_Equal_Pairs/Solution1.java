package Divide_Array_Into_Equal_Pairs;

import java.util.HashMap;

public class Solution1 {
	public boolean divideArray(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int ele : nums) {
			map.put(ele, map.getOrDefault(ele, 0) + 1);
		}

		for (int ele : map.values()) {
			if (ele % 2 != 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 3, 2, 2, 2 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.divideArray(nums));
	}
}
