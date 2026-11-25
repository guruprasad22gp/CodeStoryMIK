package Find_Numbers_with_Even_Number_of_Digits;

public class Solution4 {
	public int findNumbers(int[] nums) {
		int count = 0;
		for (int ele : nums) {
			count += Math.ceil(Math.log10(ele + 1)) % 2 == 0 ? 1 : 0;
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 12, 345, 2, 6, 7896 };
		Solution4 sol1 = new Solution4();
		System.out.println("Output: " + sol1.findNumbers(nums));
	}
}