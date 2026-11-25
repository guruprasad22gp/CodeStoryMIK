package Distribute_Elements_Into_Two_Arrays_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class SegmentTree {
	int n;
	int[] tree;

	SegmentTree(int n) {
		this.n = n;
		tree = new int[4 * n];
	}

	void update(int compressedValueIdx) {
		update(0, 0, n - 1, compressedValueIdx);
	}

	void update(int i, int start, int end, int compressedValueIdx) {
		if (start == end) {
			tree[i] += 1;
			return;
		}

		int mid = start + (end - start) / 2;
		if (compressedValueIdx <= mid) {
			update(2 * i + 1, start, mid, compressedValueIdx);
		} else {
			update(2 * i + 2, mid + 1, end, compressedValueIdx);
		}

		tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
	}

	int query(int left, int right) {
		return query(0, 0, n - 1, left, right);
	}

	int query(int i, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}

		if (left <= start && right >= end) {
			return tree[i];
		}

		int mid = start + (end - start) / 2;
		int leftVal = query(2 * i + 1, start, mid, left, right);
		int rightVal = query(2 * i + 2, mid + 1, end, left, right);
		return leftVal + rightVal;
	}
}

public class Solution2 {
	public int[] resultArray(int[] nums) {
		int n = nums.length;
		int[] temp = Arrays.copyOf(nums, n);
		Arrays.sort(temp);
		HashMap<Integer, Integer> map = new HashMap<>();
		int i = 0;
		for (int ele : temp) {
			if (map.containsKey(ele)) {
				continue;
			}

			map.put(ele, i);
			i++;
		}

		int m = map.size();
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();

		SegmentTree st1 = new SegmentTree(m);
		SegmentTree st2 = new SegmentTree(m);

		arr1.add(nums[0]);
		st1.update(map.get(nums[0]));

		arr2.add(nums[1]);
		st2.update(map.get(nums[1]));

		for (i = 2; i < n; i++) {
			int compressedValueIdx = map.get(nums[i]);
			int count1 = st1.query(compressedValueIdx + 1, m - 1);
			int count2 = st2.query(compressedValueIdx + 1, m - 1);

			if (count1 > count2) {
				arr1.add(nums[i]);
				st1.update(compressedValueIdx);
			} else if (count2 > count1) {
				arr2.add(nums[i]);
				st2.update(compressedValueIdx);
			} else {
				if (arr1.size() <= arr2.size()) {
					arr1.add(nums[i]);
					st1.update(compressedValueIdx);
				} else {
					arr2.add(nums[i]);
					st2.update(compressedValueIdx);
				}
			}
		}

		int[] result = new int[n];
		i = 0;

		for (int ele : arr1) {
			result[i++] = ele;
		}

		for (int ele : arr2) {
			result[i++] = ele;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 14, 3, 1, 2 };
		Solution2 sol1 = new Solution2();
		int[] res = sol1.resultArray(nums);
		for (int ele : res) {
			System.out.print(ele + " ");
		}
	}
}