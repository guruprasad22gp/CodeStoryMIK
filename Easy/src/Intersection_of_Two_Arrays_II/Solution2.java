package Intersection_of_Two_Arrays_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
	public static void main(String[] args) {
		int[] nums1 = { 4, 9, 5 };
		int[] nums2 = { 9, 4, 9, 8, 4 };

		Solution2 sol1 = new Solution2();

		int[] res = sol1.intersect(nums1, nums2);
		for (int ele : res) {
			System.out.print(ele + " ");
		}
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0;
		int j = 0;
		List<Integer> ans = new ArrayList<>();
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				ans.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}

		i = 0;
		int[] result = new int[ans.size()];
		for (int ele : ans) {
			result[i++] = ele;
		}

		return result;
	}
}
