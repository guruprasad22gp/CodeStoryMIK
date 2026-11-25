package Min_Max_Query_Update;

import java.util.ArrayList;

class Node {
	int min;
	int max;

	Node() {
		this.min = 0;
		this.max = 0;
	}

	Node(int min, int max) {
		this.min = min;
		this.max = max;
	}
}

class SegmentTree {
	int n;
	Node[] tree;
	Node[] lazy;

	SegmentTree(int[] arr) {
		n = arr.length;
		tree = new Node[4 * n];
		lazy = new Node[4 * n];

		for (int i = 0; i < 4 * n; i++) {
			lazy[i] = new Node();
		}

		build(0, 0, n - 1, arr);
	}

	private void build(int i, int start, int end, int[] arr) {
		if (start == end) {
			tree[i] = new Node(arr[start], arr[end]);
			return;
		}

		int mid = start + (end - start) / 2;
		build(2 * i + 1, start, mid, arr);
		build(2 * i + 2, mid + 1, end, arr);

		tree[i] = new Node(Math.min(tree[2 * i + 1].min, tree[2 * i + 2].min),
				Math.max(tree[2 * i + 1].max, tree[2 * i + 2].max));
	}

	void update(int left, int right, int addEle) {
		update(0, 0, n - 1, left, right, addEle);
	}

	private void update(int i, int start, int end, int left, int right, int addEle) {
		if (lazy[i] != null) {
			tree[i].min += lazy[i].min;
			tree[i].max += lazy[i].max;

			if (start != end) {
				lazy[2 * i + 1].min += lazy[i].min;
				lazy[2 * i + 1].max += lazy[i].max;
				lazy[2 * i + 2].min += lazy[i].min;
				lazy[2 * i + 2].max += lazy[i].max;
			}

			lazy[i].min = 0;
			lazy[i].max = 0;
		}

		if (right < start || left > end) {
			return;
		}

		if (left <= start && right >= end) {
			tree[i].min += addEle;
			tree[i].max += addEle;

			if (start != end) {
				lazy[2 * i + 1].min += addEle;
				lazy[2 * i + 1].max += addEle;
				lazy[2 * i + 2].min += addEle;
				lazy[2 * i + 2].max += addEle;
			}
			return;
		}

		int mid = start + (end - start) / 2;
		update(2 * i + 1, start, mid, left, right, addEle);
		update(2 * i + 2, mid + 1, end, left, right, addEle);

		tree[i].min = Math.min(tree[2 * i + 1].min, tree[2 * i + 2].min);
		tree[i].max = Math.max(tree[2 * i + 1].max, tree[2 * i + 2].max);
	}

	Node query(int left, int right) {
		return query(0, 0, n - 1, left, right);
	}

	private Node query(int i, int start, int end, int left, int right) {
		if (right < start || left > end) {
			return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		if (lazy[i] != null) {
			tree[i].min += lazy[i].min;
			tree[i].max += lazy[i].max;

			if (start != end) {
				lazy[2 * i + 1].min += lazy[i].min;
				lazy[2 * i + 1].max += lazy[i].max;
				lazy[2 * i + 2].min += lazy[i].min;
				lazy[2 * i + 2].max += lazy[i].max;
			}

			lazy[i].min = 0;
			lazy[i].max = 0;
		}

		if (left <= start && right >= end) {
			return tree[i];
		}

		int mid = start + (end - start) / 2;
		Node leftNode = query(2 * i + 1, start, mid, left, right);
		Node rightNode = query(2 * i + 2, mid + 1, end, left, right);

		return new Node(Math.min(leftNode.min, rightNode.min), Math.max(leftNode.max, rightNode.max));
	}
}

public class Solution1 {
	public ArrayList<Node> find(int[] arr, int[][] queries) {
		ArrayList<Node> result = new ArrayList<>();

		SegmentTree st = new SegmentTree(arr);
		for (int[] x : queries) {
			if (x[0] == 0) {
				int startIndex = x[1];
				int endIndex = x[2];
				result.add(st.query(startIndex, endIndex));
			} else {
				int left = x[1];
				int right = x[2];
				int addEle = x[3];
				st.update(left, right, addEle);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 7, 2, 8, 3, 4, 5, 6, 2, 9, };
		int[][] queries = { { 0, 1, 5 }, { 0, 0, 7 }, { 1, 2, 6, +1 }, { 0, 2, 6 }, { 0, 4, 7 } };

		Solution1 sol1 = new Solution1();
		ArrayList<Node> result = sol1.find(arr, queries);
		for (Node ans : result) {
			System.out.println(ans.min + " : " + ans.max);
		}
	}
}