package Count_Symmetric_Integers;

public class Solution2 {
	public int countSymmetricIntegers(int low, int high) {
		int count = 0;
		for (int start = low; start <= high; start++) {
			if (start >= 10 && start <= 99 && start % 11 == 0) {
				count++;
			} else if (start >= 1000 && start <= 9999) {
				int first = start / 1000;
				int second = (start / 100) % 10;
				int third = (start / 10) % 10;
				int fourth = start % 10;
				if (first + second == third + fourth) {
					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int low = 1;
		int high = 10000;
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.countSymmetricIntegers(low, high));
	}
}