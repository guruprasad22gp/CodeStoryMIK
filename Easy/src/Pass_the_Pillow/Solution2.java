package Pass_the_Pillow;

public class Solution2 {
	public int passThePillow(int n, int time) {
		int div = time / (n - 1);
		int rem = time % (n - 1);

		if (div % 2 == 0) {
			return 1 + rem;
		} else {
			return n - rem;
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int time = 13;

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.passThePillow(n, time));
	}
}
