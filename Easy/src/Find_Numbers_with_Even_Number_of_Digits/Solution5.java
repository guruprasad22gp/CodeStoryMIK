package Find_Numbers_with_Even_Number_of_Digits;

public class Solution5 {
	public int findNumbers(int[] nums) {
		int count = 0;
		for (int ele : nums) {
			if ((10 <= ele && ele <= 99) || (1000 <= ele && ele <= 9999) || (ele == 100000)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 12, 345, 2, 6, 7896 };
		Solution5 sol1 = new Solution5();
		System.out.println("Output: " + sol1.findNumbers(nums));
	}
}