package Count_the_Number_of_Consistent_Strings;

public class Solution2 {
	public int countConsistentStrings(String allowed, String[] words) {
		boolean[] count = new boolean[26];
		for (char ch : allowed.toCharArray()) {
			count[ch - 'a'] = true;
		}

		int result = 0;
		for (String s : words) {
			boolean found = true;
			for (char ch : s.toCharArray()) {
				int idx = ch - 'a';
				if (!count[idx]) {
					found = false;
					break;
				}
			}

			if (found) {
				result++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String allowed = "ab";
		String[] words = { "ad", "bd", "aaab", "baa", "badab" };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.countConsistentStrings(allowed, words));
	}
}
