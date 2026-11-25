package Minimum_String_Length_After_Removing_Substrings;

public class Solution2 {
	public int minLength(String s) {
		int i = 0;
		int j = 1;
		int n = s.length();
		char[] arr = s.toCharArray();

		while (j < n) {
			if (i < 0) {
				i++;
				arr[i] = arr[j];
			} else if ((arr[i] == 'A' && arr[j] == 'B') || (arr[i] == 'C' && arr[j] == 'D')) {
				i--;
			} else {
				i++;
				arr[i] = arr[j];
			}
			j++;
		}

		return i + 1;
	}

	public static void main(String[] args) {
		String s = "ABFCACDBD";
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.minLength(s));
	}
}
