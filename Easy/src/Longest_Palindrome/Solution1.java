package Longest_Palindrome;

import java.util.HashSet;

public class Solution1 {
	public static void main(String[] args) {
		String s = "abccccdd";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.longestPalindrome(s));
	}

	public int longestPalindrome(String s) {
		int result = 0;
		HashSet<Character> set = new HashSet<>();
		for (char ch : s.toCharArray()) {
			if (set.contains(ch)) {
				result += 2;
				set.remove(ch);
			} else {
				set.add(ch);
			}
		}

		if (!set.isEmpty()) {
			result += 1;
		}

		return result;
	}
}
