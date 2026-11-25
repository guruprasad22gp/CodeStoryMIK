package Range_Sum_Query;

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

		tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
	}

	int query(int node, int start, int end, int left, int right) {
		if (right < start || left > end) {
			return 0;
		}

		if (left <= start && right >= end) {
			return tree[node];
		}

		int mid = start + (end - start) / 2;
		return query(2 * node + 1, start, mid, left, right) + query(2 * node + 2, mid + 1, end, left, right);

	}
}

class Solution1 {
	public static void main(String[] args) {
		Solution1 sol1 = new Solution1();

		int arr[] = { 1, 2, 3, 4 };
		int queries[][] = { { 1, 4 }, { 2, 3 } };

		System.out.println("Output: " + sol1.querySum(arr, queries));
	}

	public ArrayList<Integer> querySum(int[] arr, int[][] queries) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		SegmentTree seg = new SegmentTree(arr);

		for (int[] x : queries) {
			ans.add(seg.query(0, 0, arr.length - 1, x[0] - 1, x[1] - 1));
		}

		return ans;
	}
}
