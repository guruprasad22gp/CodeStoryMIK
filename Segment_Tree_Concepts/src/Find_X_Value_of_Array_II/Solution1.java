package Find_X_Value_of_Array_II;

import java.util.Arrays;

class Node {
	int product;
	int[] freq;

	Node(int k) {
		product = 1;
		freq = new int[k];
	}
}

class SegmentTree {
	int k;
	int n;
	Node[] tree;

	SegmentTree(int k, int[] nums) {
		this.k = k;
		this.n = nums.length;
		tree = new Node[4 * n];
		for (int i = 0; i < 4 * n; i++) {
			tree[i] = new Node(k);
		}
		build(0, 0, n - 1, nums);
	}

	void build(int i, int start, int end, int[] nums) {
		if (start == end) {
			setLeafNode(i, nums[start]);
			return;
		}

		int mid = start + (end - start) / 2;
		build(2 * i + 1, start, mid, nums);
		build(2 * i + 2, mid + 1, end, nums);
		tree[i] = merge(tree[2 * i + 1], tree[2 * i + 2]);
	}

	Node merge(Node left, Node right) {
		Node result = new Node(k);
		result.product = (left.product * right.product) % k;
		for (int i = 0; i < k; i++) {
			result.freq[i] = left.freq[i];
		}

		for (int i = 0; i < k; i++) {
			int rem = (left.product * i) % k;
			result.freq[rem] += right.freq[i];
		}
		return result;
	}

	void setLeafNode(int i, int val) {
		Arrays.fill(tree[i].freq, 0);
		int rem = val % k;
		tree[i].product = rem;
		tree[i].freq[rem] = 1;
	}

	void update(int index, int val) {
		update(0, 0, n - 1, index, val);
	}

	void update(int i, int start, int end, int index, int val) {
		if (start == end) {
			setLeafNode(i, val);
			return;
		}
		int mid = start + (end - start) / 2;
		if (index <= mid) {
			update(2 * i + 1, start, mid, index, val);
		} else {
			update(2 * i + 2, mid + 1, end, index, val);
		}
		tree[i] = merge(tree[2 * i + 1], tree[2 * i + 2]);
	}

	Node query(int left) {
		return query(0, 0, n - 1, left, n - 1);
	}

	Node query(int i, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return null;
		}

		if (left <= start && right >= end) {
			return tree[i];
		}

		int mid = start + (end - start) / 2;
		Node leftVal = query(2 * i + 1, start, mid, left, right);
		Node rightVal = query(2 * i + 2, mid + 1, end, left, right);
		if (leftVal == null) {
			return rightVal;
		}

		if (rightVal == null) {
			return leftVal;
		}

		return merge(leftVal, rightVal);
	}
}

public class Solution1 {
	public int[] resultArray(int[] nums, int k, int[][] queries) {
        int q = queries.length;
        int[] res = new int[q];

        SegmentTree st = new SegmentTree(k, nums);
        int idx = 0;
        for(int[] x: queries) {
            int index = x[0];
            int val = x[1];
            int start = x[2];
            int rem = x[3];
            st.update(index, val);
            res[idx++] = st.query(start).freq[rem];
        }
        return res;
    }

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		int k = 3;
		int[][] queries = { { 2, 2, 0, 2 }, { 3, 3, 3, 0 }, { 0, 1, 0, 1 } };
		Solution1 sol1 = new Solution1();
		int[] res = sol1.resultArray(nums, k, queries);
		System.out.println("Output: " + Arrays.toString(res));
	}
}