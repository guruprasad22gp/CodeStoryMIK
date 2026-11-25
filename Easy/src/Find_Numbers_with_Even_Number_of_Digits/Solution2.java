package Find_Numbers_with_Even_Number_of_Digits;

public class Solution2 {
	public int findNumbers(int[] nums) {
		int count = 0;
		for (int ele : nums) {
			int digit = 0;
			while (ele > 0) {
				digit++;
				ele /= 10;
			}
			count += digit % 2 == 0 ? 1 : 0;
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 12, 345, 2, 6, 7896 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.findNumbers(nums));
	}
}
