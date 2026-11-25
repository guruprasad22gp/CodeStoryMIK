package Clear_Digits;

public class Solution2 {
	public String clearDigits(String s) {
		StringBuilder curr = new StringBuilder(s);
		int i = 0;
		while (i < curr.length()) {
			if (Character.isDigit(curr.charAt(i))) {
				curr.deleteCharAt(i);
				if (i - 1 >= 0) {
					curr.deleteCharAt(i - 1);
					i--;
				}
			} else {
				i++;
			}
		}

		return curr.toString();
	}

	public static void main(String[] args) {
		String s = "adc23";
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.clearDigits(s));
	}
}
