package Find_Building_Where_Alice_and_Bob_Can_Meet;

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

		tree[i] = arr[tree[2 * i + 1]] >= arr[tree[2 * i + 2]] ? tree[2 * i + 1] : tree[2 * i + 2];
	}

	int query(int i, int start, int end, int left, int right, int[] arr) {
		if (right < start || left > end) {
			return -1;
		}

		if (left <= start && right >= end) {
			return tree[i];
		}

		int mid = start + (end - start) / 2;
		int leftIndex = query(2 * i + 1, start, mid, left, right, arr);
		int rightIndex = query(2 * i + 2, mid + 1, end, left, right, arr);

		if (leftIndex != -1 && rightIndex != -1) {
			if (arr[leftIndex] >= arr[rightIndex]) {
				return leftIndex;
			} else {
				return rightIndex;
			}
		} else if (leftIndex == -1) {
			return rightIndex;
		} else {
			return leftIndex;
		}
	}

	int binarySearch(int index, int maxEle, int[] arr) {
		int left = index + 1;
		int right = n - 1;
		int res = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int idx = query(0, 0, n - 1, left, mid, arr);
			if (idx != -1 && arr[idx] > maxEle) {
				res = Math.min(res, idx);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return res == Integer.MAX_VALUE ? -1 : res;
	}
}