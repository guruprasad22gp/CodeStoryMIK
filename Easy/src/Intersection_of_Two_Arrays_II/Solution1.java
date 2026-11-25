package Intersection_of_Two_Arrays_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
	public static void main(String[] args) {
		int[] nums1 = { 4, 9, 5 };
		int[] nums2 = { 9, 4, 9, 8, 4 };

		Solution1 sol1 = new Solution1();

		int[] res = sol1.intersect(nums1, nums2);
		for (int ele : res) {
			System.out.print(ele + " ");
		}
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int ele : nums1) {
			map.put(ele, map.getOrDefault(ele, 0) + 1);
		}

		List<Integer> ans = new ArrayList<>();
		for (int ele : nums2) {
			if (map.containsKey(ele) && map.get(ele) > 0) {
				ans.add(ele);
				map.put(ele, map.getOrDefault(ele, 0) - 1);
			}
		}

		int i = 0;
		int[] res = new int[ans.size()];
		for (int ele : ans) {
			res[i++] = ele;
		}

		return res;
	}
}
