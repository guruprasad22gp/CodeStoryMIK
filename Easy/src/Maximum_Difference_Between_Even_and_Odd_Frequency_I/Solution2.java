package Maximum_Difference_Between_Even_and_Odd_Frequency_I;

import java.util.HashMap;

public class Solution2 {
	public int maxDifference(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int ele : map.values()) {
			if (ele % 2 == 0) {
				min = Math.min(min, ele);
			} else {
				max = Math.max(max, ele);
			}
		}
		return max - min;
	}

	public static void main(String[] args) {
		String s = "aaaaabbc";
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.maxDifference(s));
	}
}