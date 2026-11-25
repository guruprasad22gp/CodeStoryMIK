package Two_Sum_II__Input_Array_Is_Sorted;

import java.util.Arrays;

public class Solution1 {
	public int[] twoSum(int[] numbers, int target) {
		int n = numbers.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (numbers[i] + numbers[j] == target) {
					return new int[] { i + 1, j + 1 };
				}
			}
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		int[] numbers = { 2, 7, 11, 15 };
		int target = 9;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + Arrays.toString(sol1.twoSum(numbers, target)));
	}
}