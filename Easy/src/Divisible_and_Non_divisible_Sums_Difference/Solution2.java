package Divisible_and_Non_divisible_Sums_Difference;

public class Solution2 {
	public int differenceOfSums(int n, int m) {
		int k = n / m;
		return (n * (n + 1)) / 2 - m * k * (k + 1);
	}

	public static void main(String[] args) {
		int n = 10;
		int m = 3;

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.differenceOfSums(n, m));
	}
}