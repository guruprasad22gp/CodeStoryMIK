package Minimum_Number_of_Flips_to_Make_the_Binary_String_Alternating;

public class Solution2 {
	public int minFlips(String str) {
		int n = str.length();
		int result1 = 0;
		int result2 = 0;

		for (int i = 0; i < n; i++) {
			char ch1 = i % 2 == 0 ? '0' : '1';
			char ch2 = i % 2 == 1 ? '0' : '1';
			if (ch1 != str.charAt(i)) {
				result1++;
			}

			if (ch2 != str.charAt(i)) {
				result2++;
			}
		}

		int minFlip = Math.min(result1, result2);

		for (int i = n; i < 2 * n; i++) {
			char ch1 = i % 2 == 0 ? '0' : '1';
			char ch2 = i % 2 == 1 ? '0' : '1';
			char prevCh1 = (i - n) % 2 == 0 ? '0' : '1';
			char prevCh2 = (i - n) % 2 == 1 ? '0' : '1';
			if (str.charAt(i % n) != ch1) {
				result1++;
			}

			if (str.charAt(i % n) != prevCh1) {
				result1--;
			}

			if (str.charAt(i % n) != ch2) {
				result2++;
			}

			if (str.charAt(i % n) != prevCh2) {
				result2--;
			}

			minFlip = Math.min(minFlip, Math.min(result1, result2));
		}

		return minFlip;

	}

	public static void main(String[] args) {
		String s = "111000";

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.minFlips(s));
	}
}