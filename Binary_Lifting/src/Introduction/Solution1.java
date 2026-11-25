package Introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

		BinaryTree bt = new BinaryTree();
		Node root = bt.build(arr);
		bt.print(root);
		System.out.println();

		Solution1 sol1 = new Solution1();

		int[][] res = sol1.getAnswer(root);
		for (int[] x : res) {
			System.out.println(Arrays.toString(x));
		}
	}

	public int[][] getAnswer(Node root) {
		List<Integer> depths = new ArrayList<>();

		DFS(root, depths, -1);

		int n = depths.size();
		int colSize = (int) (Math.log10(n) / Math.log10(2)) + 2;

		int[][] parent = new int[n][colSize];

		for (int[] x : parent) {
			Arrays.fill(x, -1);
		}

		for (int i = 0; i < n; i++) {
			parent[i][0] = depths.get(i);
		}

		for (int j = 1; j < colSize; j++) {
			for (int node = 0; node < n; node++) {
				if (parent[node][j - 1] != -1) {
					parent[node][j] = parent[parent[node][j - 1]][j - 1];
				}
			}
		}

		return parent;
	}

	private void DFS(Node root, List<Integer> depths, int depth) {
		if (root == null) {
			return;
		}
		depths.add(depth);
		DFS(root.left, depths, depth + 1);
		DFS(root.right, depths, depth + 1);
	}
}