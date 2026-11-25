package Two_Sum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution2 {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int remaining = target - nums[i];
			if (map.containsKey(remaining)) {
				return new int[] { map.get(remaining), i };
			}
			map.put(nums[i], i);
		}

		return new int[] {};
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + Arrays.toString(sol1.twoSum(nums, target)));
	}
}