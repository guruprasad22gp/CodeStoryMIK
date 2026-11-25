package Crawler_Log_Folder;

public class Solution1 {
	public int minOperations(String[] logs) {
		int depth = 0;

		for (String s : logs) {
			if (s.equals("../")) {
				if (depth > 0) {
					depth--;
				} else {
					depth = 0;
				}
			} else if (s.equals("./")) {

			} else {
				depth++;
			}
		}

		return depth;
	}

	public static void main(String[] args) {
		String[] logs = { "d1/", "d2/", "../", "d21/", "./" };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minOperations(logs));
	}
}
