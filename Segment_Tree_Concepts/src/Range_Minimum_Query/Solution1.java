package Range_Minimum_Query;

import java.util.ArrayList;

class SegmentTree {
	int[] tree;
	int n;

	SegmentTree(int[] arr) {
		n = arr.length;
		tree = new int[4 * n];
		build(0, 0, n - 1, arr);

	}

	void build(int node, int start, int end, int[] arr) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}

		int mid = start + (end - start) / 2;
		build(2 * node + 1, start, mid, arr);
		build(2 * node + 2, mid + 1, end, arr);

		tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 1]);
	}

	int query(int node, int start, int end, int left, int right) {
		if (right < start || left > end) {
			return Integer.MAX_VALUE;
		}

		if (left <= start && right >= end) {
			return tree[node];
		}

		int mid = start + (end - start) / 2;
		int leftSide = query(2 * node + 1, start, mid, left, right);
		int rightSide = query(2 * node + 2, mid + 1, end, left, right);

		return Math.min(leftSide, rightSide);
	}
}

public class Solution1 {
	public ArrayList<Integer> rangeMinQuery(int[] arr, int[][] queries) {
		SegmentTree st = new SegmentTree(arr);
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int[] x : queries) {
			result.add(st.query(0, 0, arr.length - 1, x[0], x[1]));
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int queries[][] = { { 0, 2 }, { 2, 3 } };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.rangeMinQuery(arr, queries));
	}
}
