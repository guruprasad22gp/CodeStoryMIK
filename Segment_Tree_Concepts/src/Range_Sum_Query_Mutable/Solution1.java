package Range_Sum_Query_Mutable;

import java.util.ArrayList;

class SegmentTree {
	int n;
	int[] tree;

	SegmentTree(int[] arr) {
		n = arr.length;
		tree = new int[4 * n];
		build(0, 0, n - 1, arr);
	}

	void build(int i, int start, int end, int[] arr) {
		if (start == end) {
			tree[i] = arr[start];
			return;
		}

		int mid = start + (end - start) / 2;
		build(2 * i + 1, start, mid, arr);
		build(2 * i + 2, mid + 1, end, arr);

		tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
	}

	void update(int index, int val) {
		update(0, 0, n - 1, index, val);
	}

	void update(int i, int start, int end, int index, int val) {
		if (start == end) {
			tree[i] = val;
			return;
		}

		int mid = start + (end - start) / 2;
		if (index <= mid) {
			update(2 * i + 1, start, mid, index, val);
		} else {
			update(2 * i + 2, mid + 1, end, index, val);
		}

		tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
	}

	int getQuery(int left, int right) {
		return getQuery(0, 0, n - 1, left, right);
	}

	int getQuery(int i, int start, int end, int left, int right) {
		if (right < start || left > end) {
			return 0;
		}

		if (left <= start && right >= end) {
			return tree[i];
		}

		int mid = start + (end - start) / 2;
		int leftSide = getQuery(2 * i + 1, start, mid, left, right);
		int rightSide = getQuery(2 * i + 2, mid + 1, end, left, right);

		return leftSide + rightSide;
	}
}

public class Solution1 {
	ArrayList<Integer> queries(int[] arr, int[][] query) {
		ArrayList<Integer> result = new ArrayList<>();
		SegmentTree st = new SegmentTree(arr);

		for (int[] x : query) {
			if (x[0] == 0) {
				result.add(st.getQuery(x[1], x[2]));
			} else {
				st.update(x[1], x[2]);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[][] queries = { { 0, 2, 4 }, { 1, 5, 6 } };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.queries(arr, queries));
	}
}
