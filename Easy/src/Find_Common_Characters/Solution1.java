package Find_Common_Characters;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	public List<String> commonChars(String[] words) {
		int[] count = new int[26];

		for (char ch : words[0].toCharArray()) {
			count[ch - 'a']++;
		}

		for (int i = 1; i < words.length; i++) {
			int[] freq = new int[26];
			for (char ch : words[i].toCharArray()) {
				freq[ch - 'a']++;
			}

			for (int j = 0; j < 26; j++) {
				count[j] = Math.min(freq[j], count[j]);
			}
		}

		List<String> res = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			int charCount = count[i];

			while (charCount > 0) {
				res.add(String.valueOf((char) (i + 'a')));
				charCount--;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String[] words = { "bella", "label", "roller" };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.commonChars(words));
	}
}
