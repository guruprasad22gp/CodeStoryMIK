package String_Matching_in_an_Array;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	public List<String> stringMatching(String[] words) {
		List<String> result = new ArrayList<>();
		int n = words.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}

				if (words[j].contains(words[i])) {
					result.add(words[i]);
					break;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String[] words = { "leetcode", "et", "code" };
		Solution1 sol1 = new Solution1();

		System.out.println("Output: " + sol1.stringMatching(words));
	}
}