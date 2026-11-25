package Clear_Digits;

import java.util.Stack;

public class Solution1 {
	public String clearDigits(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.add(ch);
			}
		}
		StringBuilder res = new StringBuilder();
		while (!stack.isEmpty()) {
			res.append(stack.pop());
		}
		return res.reverse().toString();
	}

	public static void main(String[] args) {
		String s = "adc";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.clearDigits(s));
	}
}
