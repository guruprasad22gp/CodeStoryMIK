package Search_Pattern;

import java.util.ArrayList;

public class Solution1 {
	ArrayList<Integer> search(String pat, String txt) {
		ArrayList<Integer> result = new ArrayList<>();
		int m = txt.length();

		for (int i = 0; i < m; i++) {
			if (matchingOrNot(i, 0, pat, txt)) {
				result.add(i);
			}
		}

		return result;
	}

	private boolean matchingOrNot(int i, int j, String pat, String txt) {
		int m = pat.length();
		int n = txt.length();

		while (j < m && i < n) {
			if (pat.charAt(j) != txt.charAt(i)) {
				return false;
			}
			i++;
			j++;
		}
		return j == m;
	}

	public static void main(String[] args) {
		String txt = "aabaacaadaabaaba";
		String pat = "aaba";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.search(pat, txt));
	}
}
