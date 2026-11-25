package Fruits_Into_Baskets_II;

import java.util.Arrays;

class SegmentTree {
	int n;
	int[] tree;

	SegmentTree(int[] arr) {
		n = arr.length;
		tree = new int[4 * n];
		Arrays.fill(tree, -1);
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

	boolean query(int i, int start, int end, int ele) {
		if (tree[i] < ele) {
			return false;
		}

		if (start == end) {
			tree[i] = -1;
			return true;
		}

		boolean gotBasket = false;
		int mid = start + (end - start) / 2;
		if (tree[2 * i + 1] >= ele) {
			gotBasket = query(2 * i + 1, start, mid, ele);
		} else {
			gotBasket = query(2 * i + 2, mid + 1, end, ele);
		}

		tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
		return gotBasket;
	}
}

public class Solution2 {
	public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
		SegmentTree st = new SegmentTree(baskets);
		int res = 0;

		for (int i = 0; i < fruits.length; i++) {
			int ele = fruits[i];

			if (!st.query(0, 0, fruits.length - 1, ele)) {
				res++;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] fruits = { 4, 2, 5 };
		int[] baskets = { 3, 5, 4 };

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.numOfUnplacedFruits(fruits, baskets));
	}
}
