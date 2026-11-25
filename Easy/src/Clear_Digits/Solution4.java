package Clear_Digits;

public class Solution4 {
	public String clearDigits(String s) {
		int i = 0;
		int j = 0;
		char[] arr = s.toCharArray();

		while (i < s.length()) {
			if (Character.isDigit(arr[i])) {
				if (j - 1 >= 0) {
					j--;
				}
			} else {
				arr[j] = arr[i];
				j++;
			}
			i++;
		}

		return new String(arr, 0, j);
	}

	public static void main(String[] args) {
		String s = "aq213";
		Solution4 sol1 = new Solution4();
		System.out.println("Output: " + sol1.clearDigits(s));
	}
}
