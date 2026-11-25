package Checking_Existence_of_Edge_Length_Limited_Paths;

import java.util.Arrays;

public class Solution1 {
	int[] parent;
	int[] rank;

	public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		rank = new int[n];

		int q = queries.length;
		int[][] query = new int[q][4];
		for (int i = 0; i < q; i++) {
			query[i][0] = queries[i][0];
			query[i][1] = queries[i][1];
			query[i][2] = queries[i][2];
			query[i][3] = i;
		}

		Arrays.sort(query, (a, b) -> {
			return Integer.compare(a[2], b[2]);
		});

		Arrays.sort(edgeList, (a, b) -> {
			return Integer.compare(a[2], b[2]);
		});

		boolean[] result = new boolean[q];
		int j = 0;

		for (int i = 0; i < q; i++) {
			int u = query[i][0];
			int v = query[i][1];
			int w = query[i][2];
			int idx = query[i][3];

			while (j < edgeList.length && edgeList[j][2] < w) {
				union(edgeList[j][0], edgeList[j][1]);
				j++;
			}

			if (find(u) == find(v)) {
				result[idx] = true;
			} else {
				result[idx] = false;
			}
		}

		return result;
	}

	private void union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);

		if (parentX == parentY) {
			return;
		}
		if (rank[parentX] == rank[parentY]) {
			parent[parentY] = parentX;
			rank[parentX]++;
		} else if (rank[parentX] > rank[parentY]) {
			parent[parentY] = parentX;
		} else {
			parent[parentX] = parentY;
		}
	}

	private int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return find(parent[x]);
	}

	public static void main(String[] args) {
		int n = 5;
		int[][] edgeList = { { 0, 1, 10 }, { 1, 2, 5 }, { 2, 3, 9 }, { 3, 4, 13 } };
		int[][] queries = { { 0, 4, 14 }, { 1, 4, 13 } };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + Arrays.toString(sol1.distanceLimitedPathsExist(n, edgeList, queries)));
	}
}