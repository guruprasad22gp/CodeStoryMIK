package Pass_the_Pillow;

public class Solution1 {
	public int passThePillow(int n, int time) {
		int i = 1;
		int direction = 1;

		while (time > 0) {
			if (i == n) {
				direction = 0;
			} else if (i == 1) {
				direction = 1;
			}

			if (direction == 1) {
				i++;
			} else {
				i--;
			}
			time--;
		}

		return i;
	}

	public static void main(String[] args) {
		int n = 4;
		int time = 5;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.passThePillow(n, time));
	}
}
