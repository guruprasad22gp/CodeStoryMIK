package Find_the_Difference;

public class Approach2 {
	public static void main(String[] args) {
		Approach2 m = new Approach2();
		String s = "abce";
		String t = "abcef";
		
		System.out.println("Output: " + m.findTheDifference(s, t));
	}
	
	public char findTheDifference(String s, String t) {
		int sum1 = 0;
		for(char ch: s.toCharArray()) {
			sum1 += ch;
		}
		
		int sum2 = 0;
		
		for(char ch: t.toCharArray()) {
			sum2 += ch;
		}
		
		return (char)(sum2 - sum1);
	}
}
