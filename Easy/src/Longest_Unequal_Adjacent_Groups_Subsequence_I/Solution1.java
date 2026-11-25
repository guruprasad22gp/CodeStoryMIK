package Longest_Unequal_Adjacent_Groups_Subsequence_I;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	public List<String> getLongestSubsequence(String[] words, int[] groups) {
		List<String> res = new ArrayList<>();
		res.add(words[0]);
		for (int i = 1; i < words.length; i++) {
			if (groups[i] == groups[i - 1]) {
				continue;
			}
			res.add(words[i]);
		}

		return res;
	}

	public static void main(String[] args) {
		String[] words = { "e", "a", "b" };
		int[] groups = { 0, 0, 1 };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.getLongestSubsequence(words, groups));
	}
}