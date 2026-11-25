package Reverse_Prefix_of_Word;

public class Solution1 {
	public String reversePrefix(String word, char ch) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<word.length();i++) {
			if(ch == word.charAt(i)) {
				sb.append(word.substring(0, i+1)).reverse();
				sb.append(word.substring(i+1));
				break;
			}
		}
		
		return sb.isEmpty()? word: sb.toString();
	}

	public static void main(String[] args) {
		String s = "abcdefd";
		char ch = 'z';
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.reversePrefix(s, ch));
	}
}
