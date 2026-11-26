package Find_the_K_th_Character_in_String_Game_I;

public class Solution2 {
	public char kthCharacter(int k) {
		int setBit = Integer.bitCount(k - 1);
		return (char) ('a' + setBit);
	}

	public static void main(String[] args) {
		int k = 10;
		Solution2 sol1 = new Solution2();
		System.out.println(sol1.kthCharacter(k));
	}
}
