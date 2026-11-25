package Range_query_Update;

import java.util.ArrayList;

class SegmentTree {
	int n;
	int[] tree;
	int[] lazy;

	SegmentTree(int[] arr) {
		n = arr.length;
		tree = new int[4 * n];
		lazy = new int[4 * n];
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

		tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
	}

	int query(int node, int start, int end, int left, int right) {
		if (right < start || left > end) {
			return 0;
		}

		if (lazy[node] != 0) {
			tree[node] += (end - start + 1) * lazy[node];
			if (start != end) {
				lazy[2 * node + 1] += lazy[node];
				lazy[2 * node + 2] += lazy[node];
			}

			lazy[node] = 0;
		}

		if (left <= start && right >= end) {
			return tree[node];
		}

		int mid = start + (end - start) / 2;

		int leftSide = query(2 * node + 1, start, mid, left, right);
		int rightSide = query(2 * node + 2, mid + 1, end, left, right);

		return leftSide + rightSide;
	}

	void updateRange(int node, int start, int end, int left, int right, int val) {
		if (lazy[node] != 0) {
			tree[node] += (end - start + 1) * lazy[node];
			if (start != end) {
				lazy[2 * node + 1] += lazy[node];
				lazy[2 * node + 2] += lazy[node];
			}

			lazy[node] = 0;
		}

		if (right < start || left > end || left > right) {
			return;
		}

		if (left <= start && right >= end) {
			tree[node] += (end - start + 1) * val;
			if (start != end) {
				lazy[2 * node + 1] += val;
				lazy[2 * node + 2] += val;
			}
			return;
		}

		int mid = start + (end - start) / 2;
		updateRange(2 * node + 1, start, mid, left, right, val);
		updateRange(2 * node + 2, mid + 1, end, left, right, val);

		tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
	}

//	void print() {
//		for (int i = 0; i < 4 * n; i++) {
//			System.out.println(i + " " + tree[i]);
//		}
//	}
}

public class Solution1 {
	ArrayList<Integer> queryUpdate(int[] arr, int[][] queries) {
		SegmentTree st = new SegmentTree(arr);

		ArrayList<Integer> result = new ArrayList<>();
		for (int[] x : queries) {
			if (x[0] == 0) {
				int startIndex = x[1];
				int endIndex = x[2];
				int ans = st.query(0, 0, arr.length - 1, startIndex, endIndex);
				result.add(ans);
			} else {
				int startIndex = x[1];
				int endIndex = x[2];
				int val = x[3];
				st.updateRange(0, 0, arr.length - 1, startIndex, endIndex, val);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int[][] queries = { { 0, 1, 3 }, { 1, 2, 4, 6 }, { 0, 2, 5 } };

		Solution1 sol1 = new Solution1();

		System.out.println("Output: " + sol1.queryUpdate(arr, queries));
	}
}
