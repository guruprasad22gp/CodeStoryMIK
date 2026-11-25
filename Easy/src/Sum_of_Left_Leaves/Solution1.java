package Sum_of_Left_Leaves;

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
		if(arr[index] == -1) {
			return null;
		}
		
		Node root = new Node(arr[index]);
		root.left = buildTree(arr);
		root.right = buildTree(arr);
		
		return root;
	}
	
	void print(Node root) {
		if(root == null) {
			return;
		}
		
		print(root.left);
		System.out.print(root.val + " ");
		print(root.right);
	}
}
public class Solution1 {
    public int sumOfLeftLeaves(Node root) {
    	return solve(root, null);
    }
    
    private int solve(Node root, Node parent) {
    	if(root == null) {
    		return 0;
    	}
    	
    	if(root.left == null && root.right == null) {
    		if(parent != null && parent.left == root) {
    			return root.val;
    		}
    	}
    	
    	
    	int left = solve(root.left, root);
    	int right = solve(root.right, root);
    	
    	return right + left;
    }
    
	public static void main(String[] args) {
		int[] arr = {3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1};
		
		BinaryTree bt = new BinaryTree();
		
		Node root = bt.buildTree(arr);
		
		bt.print(root);
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.sumOfLeftLeaves(root));
		
	}
}
