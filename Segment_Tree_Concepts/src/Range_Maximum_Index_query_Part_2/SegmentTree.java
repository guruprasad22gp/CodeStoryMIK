package Range_Maximum_Index_query_Part_2;

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
			tree[i] = arr[start];
			return;
		}

		int mid = start + (end - start) / 2;
		build(2 * i + 1, start, mid, arr);
		build(2 * i + 2, mid + 1, end, arr);

		tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
	}

	int query(int i, int start, int end, int left, int right, int[] arr) {
		if (left > end || right < start) {
			return -1;
		}

		if (left <= start && right >= end) {
			return tree[i];
		}

		int mid = start + (end - start) / 2;
		int leftMax = query(2 * i + 1, start, mid, left, right, arr);
		int rightMax = query(2 * i + 2, mid + 1, end, left, right, arr);

		return Math.max(leftMax, rightMax);
	}

	int binarySearch(int index, int maxEle, int[] arr) {
		int left = index + 1;
		int right = n - 1;
		int res = Integer.MAX_VALUE;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			int max = query(0, 0, n - 1, left, mid, arr);
			if (max > maxEle) {
				res = Math.min(res, max);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return res == Integer.MAX_VALUE ? -1 : res;
	}
}
