package Special_Array_I;

public class Solution1 {
	public boolean isArraySpecial(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] % 2 == nums[i + 1] % 2) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 1, 4 };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.isArraySpecial(nums));
	}
}
