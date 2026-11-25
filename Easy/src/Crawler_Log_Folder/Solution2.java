package Crawler_Log_Folder;

import java.util.Stack;

public class Solution2 {
	public int minOperations(String[] logs) {
		Stack<String> stack = new Stack<>();
		for (String s : logs) {
			if (s.equals("../")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (s.equals("./")) {
				continue;
			} else {
				stack.add(s);
			}
		}

		return stack.size();
	}

	public static void main(String[] args) {
		String[] logs = { "d1/", "d2/", "../", "d21/", "./" };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.minOperations(logs));
	}
}
