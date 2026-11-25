package Divisible_and_Non_divisible_Sums_Difference;

public class Solution1 {
	public int differenceOfSums(int n, int m) {
		int sumDiv = 0;
		int sumNotDiv = 0;
		for (int i = 1; i <= n; i++) {
			if (i % m != 0) {
				sumNotDiv += i;
			} else {
				sumDiv += i;
			}
		}

		return sumNotDiv - sumDiv;
	}

	public static void main(String[] args) {
		int n = 10;
		int m = 3;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.differenceOfSums(n, m));
	}
}