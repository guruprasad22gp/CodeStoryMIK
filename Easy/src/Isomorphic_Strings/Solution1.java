package Isomorphic_Strings;

import java.util.HashMap;

public class Solution1 {
	public boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> mapS = new HashMap<>();
		HashMap<Character, Character> mapT = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char chS = s.charAt(i);
			char chT = t.charAt(i);

			if ((mapS.containsKey(chS) && mapS.get(chS) != chT) || (mapT.containsKey(chT) && mapT.get(chT) != chS)) {
				return false;
			}

			mapS.put(chS, chT);
			mapT.put(chT, chS);
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "edgg";
		String t = "addd";

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.isIsomorphic(s, t));
	}
}
