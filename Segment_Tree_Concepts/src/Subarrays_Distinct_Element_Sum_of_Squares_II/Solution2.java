package Subarrays_Distinct_Element_Sum_of_Squares_II;

import java.util.Arrays;

class Node {
	int sum;
	int square;

	Node() {
		this.sum = 0;
		this.square = 0;
	}
}

class SegmentTree {
	int n;
	Node[] tree;
	int[] lazy;
	int MOD = 1_000_000_007;

	SegmentTree(int n) {
		this.n = n;
		tree = new Node[4 * n];
		for (int i = 0; i < 4 * n; i++) {
			tree[i] = new Node();
		}
		lazy = new int[4 * n];
	}

	void update(int i, int start, int end, int left, int right, int val) {
		propagate(i, start, end);

		if (left > end || right < start) {
			return;
		}

		if (left <= start && right >= end) {
			lazy[i] += val;
			propagate(i, start, end);
			return;
		}

		int mid = start + (end - start) / 2;
		update(2 * i + 1, start, mid, left, right, val);
		update(2 * i + 2, mid + 1, end, left, right, val);

		tree[i].sum = (tree[2 * i + 1].sum + tree[2 * i + 2].sum) % MOD;
		tree[i].square = (tree[2 * i + 1].square + tree[2 * i + 2].square) % MOD;
	}

	void propagate(int i, int start, int end) {
		if (lazy[i] != 0) {
			int val = lazy[i];
			int len = end - start + 1;
			tree[i].square = (tree[i].square + (2 * val % MOD * tree[i].sum % MOD) % MOD
					+ (len * val % MOD * val % MOD) % MOD) % MOD;
			tree[i].sum = (tree[i].sum + len * val % MOD) % MOD;

			if (start < end) {
				lazy[2 * i + 1] += val;
				lazy[2 * i + 2] += val;
			}
			lazy[i] = 0;
		}
	}

	int query() {
		return (int) tree[0].square;
	}
}

public class Solution2 {
	public int sumCounts(int[] nums) {
		int n = nums.length;
		int[] lastSeen = new int[100001];
		Arrays.fill(lastSeen, -1);
		int res = 0;
		int MOD = 1_000_000_007;
		SegmentTree st = new SegmentTree(n);
		for (int i = 0; i < n; i++) {
			int start = lastSeen[nums[i]] + 1;
			int end = i;
			st.update(0, 0, n - 1, start, end, 1);
			res = (res + st.query()) % MOD;
			lastSeen[nums[i]] = i;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.sumCounts(nums));
	}
}