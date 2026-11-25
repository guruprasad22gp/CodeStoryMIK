package Minimum_String_Length_After_Removing_Substrings;

import java.util.Stack;

public class Solution1 {
	public int minLength(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (!stack.isEmpty() && ((stack.peek() == 'A' && ch == 'B') || (stack.peek() == 'C' && ch == 'D'))) {
				stack.pop();
			} else {
				stack.add(ch);
			}
		}

		return stack.size();
	}

	public static void main(String[] args) {
		String s = "D";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minLength(s));
	}
}
