package Divide_a_String_Into_Groups_of_Size_k;

import java.util.Arrays;

public class Solution2 {
	public String[] divideString(String s, int k, char fill) {
		int n = s.length();
		String[] res = new String[n % k == 0 ? n / k : (n / k) + 1];
		int idx = 0;
		for (int i = 0; i <= n - k; i += k) {
			String str = s.substring(i, i + k);
			res[idx++] = str;
		}

		if (n % k != 0) {
			int start = n / k * k;
			String str = s.substring(start);
			for (int i = str.length(); i < k; i++) {
				str += fill;
			}
			res[idx] = str;
		}

		return res;
	}

	public static void main(String[] args) {
		String s = "abcdefg";
		int k = 3;
		char fill = 'x';
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + Arrays.toString(sol1.divideString(s, k, fill)));
	}
}
