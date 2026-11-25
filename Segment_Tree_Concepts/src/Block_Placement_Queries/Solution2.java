package Block_Placement_Queries;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class SegmentTree {
	int n;
	int[] tree;

	SegmentTree(int n) {
		this.n = n;
		tree = new int[4 * n];
	}

	void update(int i, int start, int end, int idx, int val) {
		if (start == end) {
			tree[i] = val;
			return;
		}
		int mid = start + (end - start) / 2;
		if (idx <= mid) {
			update(2 * i + 1, start, mid, idx, val);
		} else {
			update(2 * i + 2, mid + 1, end, idx, val);
		}

		tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
	}

	int query(int i, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}

		if (left <= start && right >= end) {
			return tree[i];
		}

		int mid = start + (end - start) / 2;
		int leftVal = query(2 * i + 1, start, mid, left, right);
		int rightVal = query(2 * i + 2, mid + 1, end, left, right);
		return Math.max(leftVal, rightVal);
	}
}

public class Solution2 {
	public List<Boolean> getResults(int[][] queries) {
		int n = 50001;
		SegmentTree st = new SegmentTree(n);
		List<Boolean> result = new ArrayList<>();
		TreeSet<Integer> set = new TreeSet<>();
		set.add(0);
		set.add(n);

		for (int[] x : queries) {
			if (x[0] == 1) {
				int block = x[1];
				int prev = set.lower(block);
				int next = set.higher(block);
				st.update(0, 0, n - 1, next, next - block);
				st.update(0, 0, n - 1, block, block - prev);
				set.add(block);
			} else {
				int block = x[1];
				int blockSize = x[2];
				int lower = set.floor(block);
				int ans = st.query(0, 0, n - 1, 0, lower);
				int best = Math.max(ans, block - lower);
				result.add(best >= blockSize);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] queries = { { 1, 2 }, { 2, 3, 3 }, { 2, 3, 1 }, { 2, 2, 2 } };
		Solution2 sol1 = new Solution2();

		System.out.println("Output: " + sol1.getResults(queries));
	}
}