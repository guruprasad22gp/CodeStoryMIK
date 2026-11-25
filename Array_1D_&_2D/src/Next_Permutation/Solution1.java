package Next_Permutation;

import java.util.Arrays;

public class Solution1 {
	public void nextPermutation(int[] nums) {
		int index = -1;
		int n = nums.length;
		for (int i = n - 1; i > 0; i--) {
			if (nums[i - 1] < nums[i]) {
				index = i - 1;
				break;
			}
		}

		if (index == -1) {
			reverse(0, n - 1, nums);
		} else {
			for (int i = n - 1; i >= index + 1; i--) {
				if (nums[index] < nums[i]) {
					int temp = nums[index];
					nums[index] = nums[i];
					nums[i] = temp;
					reverse(index + 1, n - 1, nums);
					break;
				}
			}
		}
	}

	private void reverse(int left, int right, int[] arr) {
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 5, 4 };
		Solution1 sol1 = new Solution1();

		System.out.println(Arrays.toString(nums));
		sol1.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}