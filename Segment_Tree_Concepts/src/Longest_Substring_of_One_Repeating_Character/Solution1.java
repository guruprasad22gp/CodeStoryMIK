package Longest_Substring_of_One_Repeating_Character;

class Node {
	int maxLen;
	char leftChar;
	char rightChar;
	int prefixLen;
	int suffixLen;

	Node() {
		this.maxLen = 0;
		this.leftChar = 0;
		this.rightChar = 0;
		this.prefixLen = 0;
		this.suffixLen = 0;
	}

	Node(int maxLen, char leftChar, char rightChar, int prefixLen, int suffixLen) {
		this.maxLen = maxLen;
		this.leftChar = leftChar;
		this.rightChar = rightChar;
		this.prefixLen = prefixLen;
		this.suffixLen = suffixLen;
	}
}

class SegmentTree {
	int n;
	Node[] tree;

	SegmentTree(String s) {
		n = s.length();
		tree = new Node[4 * n];
		build(0, 0, n - 1, s);
	}

	void build(int i, int start, int end, String s) {
		if (start == end) {
			tree[i] = new Node(1, s.charAt(start), s.charAt(end), 1, 1);
			return;
		}

		int mid = start + (end - start) / 2;
		build(2 * i + 1, start, mid, s);
		build(2 * i + 2, mid + 1, end, s);
		tree[i] = merge(tree[2 * i + 1], tree[2 * i + 2], mid - start + 1, end - mid);
	}

	Node merge(Node left, Node right, int leftLen, int rightLen) {
		Node result = new Node();

		result.leftChar = left.leftChar;
		result.rightChar = right.rightChar;

		result.prefixLen = left.prefixLen;
		if (leftLen == left.prefixLen && left.rightChar == right.leftChar) {
			result.prefixLen = left.prefixLen + right.prefixLen;
		}

		result.suffixLen = right.suffixLen;
		if (rightLen == right.suffixLen && right.rightChar == left.rightChar) {
			result.suffixLen = right.suffixLen + left.suffixLen;
		}

		result.maxLen = Math.max(left.maxLen, right.maxLen);
		if (left.rightChar == right.leftChar) {
			result.maxLen = Math.max(result.maxLen, left.suffixLen + right.prefixLen);
		}

		return result;
	}

	void update(int i, int start, int end, int index, char ch) {
		if (start == end) {
			tree[i] = new Node(1, ch, ch, 1, 1);
			return;
		}
		int mid = start + (end - start) / 2;
		if (index <= mid) {
			update(2 * i + 1, start, mid, index, ch);
		} else {
			update(2 * i + 2, mid + 1, end, index, ch);
		}

		tree[i] = merge(tree[2 * i + 1], tree[2 * i + 2], mid - start + 1, end - mid);
	}

	int query() {
		return tree[0].maxLen;
	}
}

public class Solution1 {
	public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
		int n = queryIndices.length;
		int[] result = new int[n];

		SegmentTree st = new SegmentTree(s);
		for (int i = 0; i < n; i++) {
			char ch = queryCharacters.charAt(i);
			int index = queryIndices[i];

			st.update(0, 0, s.length() - 1, index, ch);
			result[i] = st.query();
		}

		return result;
	}

	public static void main(String[] args) {
		String s = "babacc";
		String queryCharacters = "bcb";
		int[] queryIndices = { 1, 3, 3 };

		Solution1 sol1 = new Solution1();
		int[] res = sol1.longestRepeating(s, queryCharacters, queryIndices);
		for (int ele : res) {
			System.out.print(ele + " ");
		}
	}
}