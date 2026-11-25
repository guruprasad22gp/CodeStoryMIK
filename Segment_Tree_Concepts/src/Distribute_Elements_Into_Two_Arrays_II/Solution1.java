package Distribute_Elements_Into_Two_Arrays_II;

import java.util.ArrayList;

public class Solution1 {
	public int[] resultArray(int[] nums) {
		int n = nums.length;
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.add(nums[0]);
		ArrayList<Integer> arr2 = new ArrayList<>();
		arr2.add(nums[1]);

		for (int i = 2; i < n; i++) {
			int count1 = greater(arr1, nums[i]);
			int count2 = greater(arr2, nums[i]);

			if (count1 > count2) {
				arr1.add(nums[i]);
			} else if (count2 > count1) {
				arr2.add(nums[i]);
			} else {
				if (arr1.size() <= arr2.size()) {
					arr1.add(nums[i]);
				} else {
					arr2.add(nums[i]);
				}
			}
		}
		int j = 0;
		for (int i = 0; i < arr1.size(); i++) {
			nums[j++] = arr1.get(i);
		}

		for (int i = 0; i < arr2.size(); i++) {
			nums[j++] = arr2.get(i);
		}

		return nums;
	}

	private int greater(ArrayList<Integer> arr, int target) {
		int count = 0;

		for (int ele : arr) {
			if (ele > target) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 14, 3, 1, 2 };
		Solution1 sol1 = new Solution1();
		int[] res = sol1.resultArray(nums);
		for (int ele : res) {
			System.out.print(ele + " ");
		}
	}
}
