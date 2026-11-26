package Find_the_Original_Typed_String_I;

public class Solution1 {
	public int possibleStringCount(String word) {
		int count = 1;
		for (int i = 1; i < word.length(); i++) {
			if (word.charAt(i) == word.charAt(i - 1)) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		String word = "abbcccc";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.possibleStringCount(word));
	}
}