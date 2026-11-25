package Count_the_Number_of_Consistent_Strings;

public class Solution1 {
	public int countConsistentStrings(String allowed, String[] words) {
		int mask = 0;

		for (char ch : allowed.toCharArray()) {
			int idx = ch - 'a';
			mask |= (1 << idx);
		}
		int ans = 0;
		for (String s : words) {
			boolean found = true;

			for (char ch : s.toCharArray()) {
				int idx = ch - 'a';
				if (((mask >> idx) & 1) != 1) {
					found = false;
					break;
				}
			}

			if (found) {
				ans++;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		String allowed = "ab";
		String[] words = { "ad", "bd", "aaab", "baa", "badab" };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.countConsistentStrings(allowed, words));
	}
}
