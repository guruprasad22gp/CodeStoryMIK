package Find_the_Difference;

public class Approach3 {
	public static void main(String[] args) {
		Approach3 m = new Approach3();
		String s = "abc";
		String t = "abce";
		
		System.out.println("Output: " + m.findTheDifference(s, t));
	}
	
	public char findTheDifference(String s, String t) {
		int xor = 0;
		
		for(char ch: s.toCharArray()) {
			xor ^= ch;
		}
		
		for(char ch:t.toCharArray()) {
			xor ^= ch;
		}
		
		return (char)xor;
	}
}
