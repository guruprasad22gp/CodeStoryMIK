package Rotate_String;

public class Solution2 {
	public boolean rotateString(String s, String goal) {
		return s.length() == goal.length() && (s + s).contains(goal);
	}

	public static void main(String[] args) {
		String s = "abcde";
		String goal = "abcde";

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.rotateString(s, goal));
	}
}