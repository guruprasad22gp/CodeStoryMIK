//Range sum query Problems
package BuildSegmentTree;

import java.util.ArrayList;

class SegmentTree {
	int[] tree;
	int n;

	SegmentTree(int[] arr) {
		n = arr.length;
		tree = new int[4 * n];
		buildST(0, 0, n - 1, arr);
	}

	void buildST(int node, int start, int end, int[] arr) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}

		int mid = start + (end - start) / 2;
		buildST(2 * node + 1, start, mid, arr);
		buildST(2 * node + 2, mid + 1, end, arr);
		tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
	}

	void update(int index, int node, int start, int end, int val) {
		if (start == end) {
			tree[node] = val;
			return;
		}

		int mid = start + (end - start) / 2;
		if (index <= mid) {
			update(index, 2 * node + 1, start, mid, val);
		} else {
			update(index, 2 * node + 2, mid + 1, end, val);
		}

		tree[node] = tree[2 * node + 1] + tree[2 * node + 2];

	}

	int query(int start, int end, int left, int right, int node) {
		if (right < start || left > end) {
			return 0;
		}

		if (left <= start && right >= end) {
			return tree[node];
		}

		int mid = start + (end - start) / 2;
		int sum1 = query(start, mid, left, right, 2 * node + 1);
		int sum2 = query(mid + 1, end, left, right, 2 * node + 2);

		return sum1 + sum2;

	}

	void print() {
		for (int i = 0; i < tree.length; i++) {
			System.out.println(i + ": " + tree[i]);
		}
	}
}

public class Main {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 9, 11 };
		int queries[][] = { { 1, 0, 2 }, { 2, 3, 17 }, { 1, 0, 5 } };

		Main m = new Main();
		System.out.println("Output: " + m.querySum(arr, queries));
	}

	public ArrayList<Integer> querySum(int[] arr, int[][] queries) {
		ArrayList<Integer> result = new ArrayList<>();
		SegmentTree st = new SegmentTree(arr);
		for (int[] x : queries) {
			if (x[0] == 2) {
				int index = x[1];
				int val = x[2];
				st.update(index, 0, 0, arr.length - 1, val);
			} else {
				int left = x[1];
				int right = x[2];
				result.add(st.query(0, arr.length - 1, left, right, 0));
			}
		}

		return result;
	}
}