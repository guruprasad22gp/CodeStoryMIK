package Find_the_K_th_Character_in_String_Game_I;

public class Solution1 {
	public char kthCharacter(int k) {
		String word = "a";

		while (word.length() < k) {
			String str = "";

			for (char ch : word.toCharArray()) {
				int index = ch - 'a';
				str += (char) ((index + 1) % 26 + 'a');
			}
			word += str;
		}

		return word.charAt(k - 1);
	}

	public static void main(String[] args) {
		int k = 10;
		Solution1 sol1 = new Solution1();
		System.out.println(sol1.kthCharacter(k));
	}
}
