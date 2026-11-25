package Clear_Digits;

public class Solution3 {
	public String clearDigits(String s) {
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				if (!sb.isEmpty()) {
					sb.deleteCharAt(sb.length() - 1);
				}
			} else {
				sb.append(ch);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "aqewdc213";
		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.clearDigits(s));
	}
}
