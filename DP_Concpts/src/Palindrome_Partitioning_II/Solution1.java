package Palindrome_Partitioning_II;

public class Solution1 {
	public int minCut(String s) {
		return solve(0, s.length() - 1, s);
	}

	private int solve(int i, int j, String s) {

		if (i > j) {
			return 0;
		}

		if (palindrome(i, j, s)) {
			return 0;
		}

		int result = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int ans = 1 + solve(i, k, s) + solve(k + 1, j, s);
			result = Math.min(result, ans);
		}

		return result;
	}

	private boolean palindrome(int i, int j, String s) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "abcde";

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minCut(s));
	}
}
