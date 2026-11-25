package Count_Largest_Group;

import java.util.Arrays;

public class Solution1 {
	public int countLargestGroup(int n) {
		int[] freq = new int[37];
		for (int i = 1; i <= n; i++) {
			String num = String.valueOf(i);
			int sum = 0;
			for (int j = 0; j < num.length(); j++) {
				sum += num.charAt(j) - '0';
			}

			freq[sum]++;
		}
		Arrays.sort(freq);
		int max = 1;
		int high = freq[36];
		for (int i = 35; i >= 0; i--) {
			if (high == freq[i]) {
				max++;
			} else {
				break;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int n = 10000;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.countLargestGroup(n));
	}
}