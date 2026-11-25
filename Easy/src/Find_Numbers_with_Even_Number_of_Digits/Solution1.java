package Find_Numbers_with_Even_Number_of_Digits;

public class Solution1 {
	public int findNumbers(int[] nums) {
		int count = 0;
		for (int ele : nums) {
			String num = String.valueOf(ele);
			count += num.length() % 2 == 0 ? 1 : 0;
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 12, 345, 2, 6, 7896 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.findNumbers(nums));
	}
}
