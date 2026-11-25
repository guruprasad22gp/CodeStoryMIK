package Maximize_Active_Section_with_Trade_II;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class SegmentTree {
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

	int query(int i, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}

		if (left <= start && right >= end) {
			return tree[i];
		}

		int mid = start + (end - start) / 2;
		return Math.max(query(2 * i + 1, start, mid, left, right), query(2 * i + 2, mid + 1, end, left, right));
	}
}

public class Solution1 {
	public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
		int n = s.length();
		int oneCount = 0;
		int i = 0;
		Vector<Integer> blockStart = new Vector<>();
		Vector<Integer> blockEnd = new Vector<>();
		Vector<Integer> blockSize = new Vector<>();
		while (i < n) {
			if (s.charAt(i) == '0') {
				int start = i;
				while (i < n && s.charAt(i) == '0') {
					i++;
				}

				blockStart.add(start);
				blockEnd.add(i - 1);
				blockSize.add(i - start);
			} else {
				i++;
				oneCount++;
			}
		}

		int m = blockSize.size();
		if (m < 2) {
			List<Integer> ans = new ArrayList<>();
			for (i = 0; i < queries.length; i++) {
				ans.add(oneCount);
			}
			return ans;
		}

		int N = m - 1;
		int[] pairSum = new int[N];
		for (i = 0; i < N; i++) {
			pairSum[i] = blockSize.get(i) + blockSize.get(i + 1);
		}

		SegmentTree st = new SegmentTree(pairSum);
		List<Integer> result = new ArrayList<>();

		for (int[] x : queries) {
			int l = x[0];
			int r = x[1];
			int low = lowerBound(blockEnd, l);
			int high = upperBound(blockStart, r) - 1;
			System.out.println(low + ": " + high);
			int maxPairSum = 0;
			if (low < high) {
				int firstLen = blockEnd.get(low) - Math.max(l, blockStart.get(low)) + 1;
				System.out.println(blockEnd.get(low) + " " + Math.max(low, blockStart.get(low)));
				int lastLen = Math.min(blockEnd.get(high), r) - blockStart.get(high) + 1;
				System.out.println(Math.min(blockEnd.get(high), r) + " " + blockStart.get(high));
				if (high - low == 1) {
					maxPairSum = lastLen + firstLen;
				} else {
					int pair1 = firstLen + blockSize.get(low + 1);
					int pair2 = lastLen + blockSize.get(high - 1);
					int pair3 = st.query(0, 0, N - 1, low + 1, high - 2);
					maxPairSum = Math.max(pair1, Math.max(pair2, pair3));
				}
			}

			result.add(maxPairSum + oneCount);
		}

		return result;
	}

	private int lowerBound(Vector<Integer> arr, int key) {
		int left = 0;
		int right = arr.size();

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr.get(mid) >= key) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	private int upperBound(Vector<Integer> arr, int key) {
		int left = 0;
		int right = arr.size();

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr.get(mid) > key) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	public static void main(String[] args) {
		String s = "0100";
		int[][] queries = { { 0, 3 }, { 0, 2 }, { 1, 3 }, { 2, 3 } };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxActiveSectionsAfterTrade(s, queries));
	}
}