package Two_Sum_II__Input_Array_Is_Sorted;

import java.util.Arrays;

public class Solution3 {
	public int[] twoSum(int[] numbers, int target) {
		int i = 0;
		int j = numbers.length - 1;

		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum == target) {
				return new int[] { i + 1, j + 1 };
			} else if (sum < target) {
				i++;
			} else {
				j--;
			}
		}

		return new int[] {};

	}

	public static void main(String[] args) {
		int[] numbers = { 2, 7, 11, 15 };
		int target = 9;
		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + Arrays.toString(sol1.twoSum(numbers, target)));
	}
}