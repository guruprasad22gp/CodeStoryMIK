package Count_Symmetric_Integers;

public class Solution1 {
	public int countSymmetricIntegers(int low, int high) {
		int count = 0;
		for (int start = low; start <= high; start++) {
			String num = String.valueOf(start);
			int len = num.length();

			int leftSum = 0;
			for (int i = 0; i < len / 2; i++) {
				leftSum += (int) num.charAt(i);
			}

			int rightSum = 0;
			for (int i = len / 2; i < len; i++) {
				rightSum += (int) num.charAt(i);
			}

			if (leftSum == rightSum) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int low = 1;
		int high = 10000;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.countSymmetricIntegers(low, high));
	}
}