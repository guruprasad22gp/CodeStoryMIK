package Valid_Anagram;

public class Solution2 {
	public static void main(String[] args) {
		String s = "guruprsaad";
		String t = "guurpaasrd";
		
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.isAnagram(s, t));
	}
	
	public boolean isAnagram(String s, String t) {
		int[] count = new int[26];
		for(char ch: s.toCharArray()) {
			count[ch - 'a']++;
		}
		
		for(char ch: t.toCharArray()) {
			count[ch - 'a']--;
		}
		
		for(int i=0;i<26;i++) {
			if(count[i] != 0) {
				return false;
			}
		}
		
		return true;
	}
}
