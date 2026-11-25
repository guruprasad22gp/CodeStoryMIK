package Relative_Sort_Array;

import java.util.Map;
import java.util.TreeMap;

public class Solution1 {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int ele : arr1) {
			map.put(ele, map.getOrDefault(ele, 0) + 1);
		}

		int index = 0;
		for (int ele : arr2) {
			int count = map.get(ele);

			while (count > 0) {
				arr1[index] = ele;
				index++;
				count--;
			}
			map.put(ele, 0);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int count = entry.getValue();

			while (count > 0) {
				arr1[index] = entry.getKey();
				count--;
				index++;
			}
		}

		return arr1;
	}

	public static void main(String[] args) {
		int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
		int[] arr2 = { 2, 1, 4, 3, 9, 6 };

		Solution1 sol1 = new Solution1();
		int[] ans = sol1.relativeSortArray(arr1, arr2);
		for (int ele : ans) {
			System.out.print(ele + " ");
		}
	}
}
