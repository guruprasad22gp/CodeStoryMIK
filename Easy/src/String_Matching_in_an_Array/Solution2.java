package String_Matching_in_an_Array;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	public List<String> stringMatching(String[] words) {
		List<String> result = new ArrayList<>();
		int n = words.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				if (KMPsearch(words[i], words[j])) {
					result.add(words[i]);
					break;
				}
			}
		}

		return result;
	}

	boolean KMPsearch(String pat, String txt) {
		int n = pat.length();
		int m = txt.length();
		int[] LPS = new int[n];
		lps(pat, LPS);
		int i = 0;
		int j = 0;

		while (i < m) {
			if (pat.charAt(j) == txt.charAt(i)) {
				i++;
				j++;
			}

			if (j == n) {
				return true;
			} else if (i < m && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0) {
					j = LPS[j - 1];
				} else {
					i++;
				}
			}
		}

		return false;
	}

	void lps(String pat, int[] LPS) {
		int i = 1;
		int len = 0;
		int m = pat.length();

		while (i < m) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				LPS[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = LPS[len - 1];
				} else {
					i++;
				}
			}
		}
	}

	public static void main(String[] args) {
		String[] words = { "leetcode", "et", "code" };
		Solution2 sol1 = new Solution2();

		System.out.println("Output: " + sol1.stringMatching(words));
	}
}