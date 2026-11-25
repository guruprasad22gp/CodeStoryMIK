package Check_if_One_String_Swap_Can_Make_Strings_Equal;

public class Solution1 {
	public boolean areAlmostEqual(String s1, String s2) {
		int count = 0;
		int[] freq = new int[26];
		for (char ch : s1.toCharArray()) {
			freq[ch - 'a']++;
		}

		for (int i = 0; i < s1.length(); i++) {
			if (freq[s2.charAt(i) - 'a'] == 0) {
				return false;
			}

			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
			}

			freq[s2.charAt(i) - 'a']--;

			if (count > 2) {
				return false;
			}
		}

		return true;

	}

	public static void main(String[] args) {
		String s1 = "yf", s2 = "yy";
		Solution1 sol1 = new Solution1();
		System.out.println(sol1.areAlmostEqual(s1, s2));
	}
}
