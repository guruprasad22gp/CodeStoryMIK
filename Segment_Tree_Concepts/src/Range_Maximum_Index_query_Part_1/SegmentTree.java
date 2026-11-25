package Range_Maximum_Index_query_Part_1;

public class SegmentTree {
	int n;
	int[] tree;

	SegmentTree(int[] arr) {
		n = arr.length;
		tree = new int[4 * n];
		build(0, 0, n - 1, arr);
	}

	void build(int i, int start, int end, int[] arr) {
		if (start == end) {
			tree[i] = start;
			return;
		}

		int mid = start + (end - start) / 2;
		build(2 * i + 1, start, mid, arr);
		build(2 * i + 2, mid + 1, end, arr);

		tree[i] = arr[tree[2 * i + 1]] < arr[tree[2 * i + 2]] ? tree[2 * i + 2] : tree[2 * i + 1];
	}

	int query(int left, int right, int[] arr) {
		return query(0, 0, n - 1, left, right, arr);
	}

	int query(int i, int start, int end, int left, int right, int[] arr) {
		if (right < start || left > end) {
			return -1;
		}

		if (left <= start && right >= end) {
			return tree[i];
		}

		int mid = start + (end - start) / 2;
		int leftSide = query(2 * i + 1, start, mid, left, right, arr);
		int rightSide = query(2 * i + 2, mid + 1, end, left, right, arr);
		if (leftSide == -1) {
			return rightSide;
		}

		if (rightSide == -1) {
			return leftSide;
		}

		if (arr[leftSide] >= arr[rightSide]) {
			return leftSide;
		} else {
			return rightSide;
		}

	}
}
