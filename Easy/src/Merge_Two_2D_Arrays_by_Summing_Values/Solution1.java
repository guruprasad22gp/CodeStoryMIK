package Merge_Two_2D_Arrays_by_Summing_Values;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution1 {
	public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int[] x : nums1) {
			map.put(x[0], x[1]);
		}

		for (int[] x : nums2) {
			if (map.containsKey(x[0])) {
				int val = map.get(x[0]);
				map.put(x[0], val + x[1]);
			} else {
				map.put(x[0], x[1]);
			}
		}
		int i = 0;
		int[][] result = new int[map.size()][2];
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			result[i][0] = entry.getKey();
			result[i][1] = entry.getValue();
			i++;
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] nums1 = { { 1, 2 }, { 2, 3 }, { 4, 5 } };
		int[][] nums2 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
		Solution1 sol1 = new Solution1();
		int[][] res = sol1.mergeArrays(nums1, nums2);

		for (int[] x : res) {
			System.out.println(Arrays.toString(x));
		}
	}
}