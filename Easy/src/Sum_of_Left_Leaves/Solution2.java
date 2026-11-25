package Sum_of_Left_Leaves;

public class Solution2 {
	public int sumOfLeftLeaves(Node root) {
		return solve(root, false);
	}
	
	private int solve(Node root, boolean isLeft) {
		if(root == null) {
			return 0;
		}
		
		if(root.left == null && root.right == null) {
			if(isLeft) {
				return root.val;
			}
		}
		
		int left = solve(root.left, true);
		int right = solve(root.right, false);
		
		return left + right;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };

		BinaryTree bt = new BinaryTree();

		Node root = bt.buildTree(arr);

		bt.print(root);

		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.sumOfLeftLeaves(root));

	}
}
