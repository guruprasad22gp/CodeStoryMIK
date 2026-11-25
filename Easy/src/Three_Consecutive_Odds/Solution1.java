package Three_Consecutive_Odds;

public class Solution1 {
	public boolean threeConsecutiveOdds(int[] arr) {
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] % 2 == 1 && arr[i - 1] % 2 == 1 && arr[i + 1] % 2 == 1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 34, 3, 4, 5, 7, 23, 12 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.threeConsecutiveOdds(arr));
	}
}