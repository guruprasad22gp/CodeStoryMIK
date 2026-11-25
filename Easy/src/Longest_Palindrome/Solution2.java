package Longest_Palindrome;

public class Solution2 {
	public static void main(String[] args) {
		String s = "aba";
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.longestPalindrome(s));
	}

	public int longestPalindrome(String s) {
		int[] charCount = new int[60];
		for (char ch : s.toCharArray()) {
			charCount[ch - 'A']++;
		}

		int oddCount = 0;
		int result = 0;
		for (int num : charCount) {
			if (num % 2 == 1) {
				oddCount++;
			}
			result += num;
		}

		return oddCount == 0 ? result : result - oddCount + 1;
	}
}
