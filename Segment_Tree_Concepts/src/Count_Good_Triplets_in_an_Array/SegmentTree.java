package Count_Good_Triplets_in_an_Array;

public class SegmentTree {
	int[] tree;

	SegmentTree(int n) {
		tree = new int[4 * n];
	}

	long query(int i, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}

		if (left <= start && right >= end) {
			return tree[i];
		}

		int mid = start + (end - start) / 2;
		long leftVal = query(2 * i + 1, start, mid, left, right);
		long rightVal = query(2 * i + 2, mid + 1, end, left, right);
		return leftVal + rightVal;
	}

	void update(int i, int start, int end, int index) {
		if (start == end) {
			tree[i] = 1;
			return;
		}

		int mid = start + (end - start) / 2;
		if (index <= mid) {
			update(2 * i + 1, start, mid, index);
		} else {
			update(2 * i + 2, mid + 1, end, index);
		}

		tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
	}
}