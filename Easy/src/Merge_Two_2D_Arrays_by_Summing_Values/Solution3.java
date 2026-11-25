package Merge_Two_2D_Arrays_by_Summing_Values;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
	public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
		List<int[]> list = new ArrayList<>();
		int i = 0;
		int j = 0;
		int m = nums1.length;
		int n = nums2.length;

		while (i < m && j < n) {
			if (nums1[i][0] == nums2[j][0]) {
				list.add(new int[] { nums1[i][0], nums1[i][1] + nums2[j][1] });
				i++;
				j++;
			} else if (nums1[i][0] < nums2[j][0]) {
				list.add(new int[] { nums1[i][0], nums1[i][1] });
				i++;
			} else {
				list.add(new int[] { nums2[j][0], nums2[j][1] });
				j++;
			}
		}

		while (i < m) {
			list.add(new int[] { nums1[i][0], nums1[i][1] });
			i++;
		}

		while (j < n) {
			list.add(new int[] { nums2[j][0], nums2[j][1] });
			j++;
		}

		return list.toArray(new int[0][]);
	}

	public static void main(String[] args) {
		int[][] nums1 = { { 1, 2 }, { 2, 3 }, { 4, 5 } };
		int[][] nums2 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
		Solution3 sol1 = new Solution3();
		int[][] res = sol1.mergeArrays(nums1, nums2);

		for (int[] x : res) {
			System.out.println(Arrays.toString(x));
		}
	}
}