package Range_Min_Max_Queries;

public class SegmentTree {
	int n;
	Node[] tree;

	SegmentTree(int[] arr) {
		n = arr.length;
		tree = new Node[4 * n];
		build(0, 0, n - 1, arr);
	}

	void build(int node, int start, int end, int[] arr) {
		if (start == end) {
			tree[node] = new Node(arr[start], arr[end]);
			return;
		}

		int mid = start + (end - start) / 2;
		build(2 * node + 1, start, mid, arr);
		build(2 * node + 2, mid + 1, end, arr);

		tree[node] = new Node(Math.min(tree[2 * node + 1].min, tree[2 * node + 2].min),
				Math.max(tree[2 * node + 1].max, tree[2 * node + 2].max));
	}

	void update(int index, int val) {
		update(0, 0, n - 1, index, val);
	}

	void update(int node, int start, int end, int index, int val) {
		if (start == end) {
			tree[node] = new Node(val, val);
			return;
		}

		int mid = start + (end - start) / 2;
		if (index <= mid) {
			update(2 * node + 1, start, mid, index, val);
		} else {
			update(2 * node + 2, mid + 1, end, index, val);
		}

		tree[node] = new Node(Math.min(tree[2 * node + 1].min, tree[2 * node + 2].min),
				Math.max(tree[2 * node + 1].max, tree[2 * node + 2].max));
	}

	Node query(int left, int right) {
		return query(0, 0, n - 1, left, right);
	}

	Node query(int node, int start, int end, int left, int right) {
		if (right < start || left > end) {
			return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		if (left <= start && right >= end) {
			return tree[node];
		}

		int mid = start + (end - start) / 2;
		Node leftSide = query(2 * node + 1, start, mid, left, right);
		Node rightSide = query(2 * node + 2, mid + 1, end, left, right);

		return new Node(Math.min(leftSide.min, rightSide.min), Math.max(leftSide.max, rightSide.max));
	}
}