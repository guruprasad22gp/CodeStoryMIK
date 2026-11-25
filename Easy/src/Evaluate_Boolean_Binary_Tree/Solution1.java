package Evaluate_Boolean_Binary_Tree;

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

	Node buildTree(int[] arr) {
		index++;
		if (arr[index] == -1) {
			return null;
		}

		Node root = new Node(arr[index]);
		root.left = buildTree(arr);
		root.right = buildTree(arr);

		return root;
	}

	void print(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.val + " ");
		print(root.left);
		print(root.right);
	}
}

public class Solution1 {
	public boolean evaluateTree(Node root) {
		return solve(root);
	}

	private boolean solve(Node root) {
		if (root.left == null && root.right == null) {
			return root.val == 1 ? true : false;
		}

		boolean left = solve(root.left);
		boolean right = solve(root.right);

		if (root.val == 2) {
			return left | right;
		} else {
			return left & right;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, -1, -1, 3, 0, -1, -1, 1, -1, -1 };

		BinaryTree bt = new BinaryTree();
		Node root = bt.buildTree(arr);
		bt.print(root);

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.evaluateTree(root));
	}
}
