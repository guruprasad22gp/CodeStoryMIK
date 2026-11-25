package Check_if_One_String_Swap_Can_Make_Strings_Equal;

public class Solution2 {
	public boolean areAlmostEqual(String s1, String s2) {
		int count = 0;
		int first = 0;
		int second = 0;

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
				if (count > 2) {
					return false;
				} else if (count == 1) {
					first = i;
				} else {
					second = i;
				}
			}
		}
		return s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
	}

	public static void main(String[] args) {
		String s1 = "aycrrwnvym", s2 = "aycrrwnvym";
		Solution2 sol1 = new Solution2();
		System.out.println(sol1.areAlmostEqual(s1, s2));
	}
}
