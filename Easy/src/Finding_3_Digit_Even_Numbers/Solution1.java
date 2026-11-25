package Finding_3_Digit_Even_Numbers;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution1 {
	public int[] findEvenNumbers(int[] digits) {
		TreeSet<Integer> set = new TreeSet<>();
		int n = digits.length;
		for (int i = 0; i < n; i++) {
			if (digits[i] == 0) {
				continue;
			}

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (i == j || j == k || k == i) {
						continue;
					}

					int num = digits[i] * 100 + digits[j] * 10 + digits[k];
					if (num % 2 == 0) {
						set.add(num);
					}
				}
			}
		}
		int i = 0;
		int[] res = new int[set.size()];
		for (int ele : set) {
			res[i++] = ele;
		}

		return res;
	}

	public static void main(String[] args) {
		int[] digits = { 2, 1, 3, 0 };
		Solution1 sol1 = new Solution1();
		int[] res = sol1.findEvenNumbers(digits);
		System.out.println("Output: " + Arrays.toString(res));
	}
}