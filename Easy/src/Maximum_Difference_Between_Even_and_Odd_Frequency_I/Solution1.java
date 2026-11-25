package Maximum_Difference_Between_Even_and_Odd_Frequency_I;

public class Solution1 {
	public int maxDifference(String s) {
		int[] freq = new int[26];
		for (char ch : s.toCharArray()) {
			freq[ch - 'a']++;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int ele : freq) {
			if (ele == 0) {
				continue;
			}
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
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxDifference(s));
	}
}