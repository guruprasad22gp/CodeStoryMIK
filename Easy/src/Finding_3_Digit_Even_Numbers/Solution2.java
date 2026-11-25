package Finding_3_Digit_Even_Numbers;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution2 {
	public int[] findEvenNumbers(int[] digits) {
		TreeSet<Integer> set = new TreeSet<>();
		int[] freq = new int[10];
		for (int ele : digits) {
			freq[ele]++;
		}

		for (int i = 1; i <= 9; i++) {
			if (freq[i] == 0) {
				continue;
			}

			freq[i]--;
			for (int j = 0; j <= 9; j++) {
				if (freq[j] == 0) {
					continue;
				}

				freq[j]--;
				for (int k = 0; k <= 8; k += 2) {
					if (freq[k] == 0) {
						continue;
					}

					freq[k]--;
					int num = i * 100 + j * 10 + k;
					set.add(num);
					freq[k]++;
				}

				freq[j]++;
			}

			freq[i]++;
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
		Solution2 sol1 = new Solution2();
		int[] res = sol1.findEvenNumbers(digits);
		System.out.println("Output: " + Arrays.toString(res));
	}
}