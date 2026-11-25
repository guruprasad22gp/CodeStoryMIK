package Lowest_Common_Ancestor;

import java.util.Arrays;

class Node {
	int val;
	Node left;
	Node right;

	Node(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

class BinaryTree {
	int index = -1;

	Node build(int[] arr) {
		index++;
		if (arr[index] == -1) {
			return null;
		}

		Node root = new Node(arr[index]);
		root.left = build(arr);
		root.right = build(arr);

		return root;
	}

	void print(Node root) {
		if (root == null) {
			return;
		}

		print(root.left);
		System.out.print(root.val + " ");
		print(root.right);
	}
}

public class Solution1 {
	int[][] parent;
	int col;
	int[] depths;

	int[] LCA(Node root, int[][] queries) {
		int n = max(root);

		depths = new int[n + 1];
		col = (int) (Math.log10(n) / Math.log10(2)) + 1;
		parent = new int[n + 1][col];

		for (int[] x : parent) {
			Arrays.fill(x, -1);
		}

		DFS(root, -1, 0);

		for (int j = 1; j < col; j++) {
			for (int node = 0; node <= n; node++) {
				if (parent[node][j - 1] != -1) {
					parent[node][j] = parent[parent[node][j - 1]][j - 1];
				}
			}
		}

		int i = 0;
		int m = queries.length;
		int[] res = new int[m];

		for (int[] x : queries) {
			int u = x[0];
			int v = x[1];

			res[i++] = getLCA(u, v);
		}

		return res;
	}

	int max(Node root) {
		if (root == null) {
			return 0;
		}
		return Math.max(root.val, Math.max(max(root.left), max(root.right)));
	}

	void DFS(Node root, int par, int depth) {
		if (root == null) {
			return;
		}
		parent[root.val][0] = par;
		depths[root.val] = depth;
		DFS(root.left, root.val, depth + 1);
		DFS(root.right, root.val, depth + 1);
	}

	int getLCA(int u, int v) {
		if (depths[u] != depths[v]) {
			if (depths[u] > depths[v]) {
				u = getAncestor(u, depths[u] - depths[v]);
			} else {
				v = getAncestor(v, depths[v] - depths[u]);
			}
		}

		if (u == v) {
			return u;
		}

		for (int j = col - 1; j >= 0; j--) {
			if (parent[u][j] == -1) {
				continue;
			}

			if (parent[u][j] != parent[v][j]) {
				u = parent[u][j];
				v = parent[v][j];
			}
		}

		return parent[u][0];
	}

	int getAncestor(int node, int k) {
		for (int j = 0; j < col; j++) {
			if ((k & (1 << j)) != 0) {
				node = parent[node][j];
				if (node == -1) {
					return -1;
				}
			}
		}

		return node;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 3, -1, -1, 4, -1, -1, 2, 5, -1, -1, 6, -1, -1 };
		BinaryTree bt = new BinaryTree();
		Node root = bt.build(arr);
		bt.print(root);
		System.out.println();

		int[][] queries = { { 1, 2 }, { 3, 4 }, { 0, 1 } };

		Solution1 sol1 = new Solution1();
		int[] res = sol1.LCA(root, queries);
		System.out.println(Arrays.toString(res));
	}
}