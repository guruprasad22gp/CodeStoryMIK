package Two_Sum_II__Input_Array_Is_Sorted;

import java.util.Arrays;
import java.util.HashMap;

public class Solution2 {
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int n = numbers.length;
		for (int i = 0; i < n; i++) {
			int remain = target - numbers[i];
			if (map.containsKey(remain)) {
				return new int[] { map.get(remain) + 1, i + 1 };
			}
			map.put(numbers[i], i);
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		int[] numbers = { 2, 7, 11, 15 };
		int target = 9;
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + Arrays.toString(sol1.twoSum(numbers, target)));
	}
}