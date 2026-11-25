package Rotate_String;

public class Solution1 {
	public boolean rotateString(String s, String goal) {
		int n = s.length();
		String doubled = s + s;
		for (int i = 0; i < n; i++) {
			String sub = doubled.substring(i, i + n);

			if (goal.equals(sub)) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		String s = "abcde";
		String goal = "abced";

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.rotateString(s, goal));
	}
}