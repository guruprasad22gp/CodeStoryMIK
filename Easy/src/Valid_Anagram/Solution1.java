package Valid_Anagram;

import java.util.Arrays;

public class Solution1 {
	public static void main(String[] args) {
		String s = "guruprsad";
		String t = "guurpaasrd";
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.isAnagram(s, t));
	}
	
	public boolean isAnagram(String s, String t) {
		char[] arr1 = s.toCharArray();
		char[] arr2 = t.toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		String newS = new String(arr1);
		String newT = new String(arr2);
		
		return newS.equals(newT);
	}
}
