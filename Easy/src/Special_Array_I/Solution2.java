package Special_Array_I;

public class Solution2 {
	public boolean isArraySpecial(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if ((nums[i] & 1) == (nums[i + 1] & 1)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 1, 3 };

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.isArraySpecial(nums));
	}
}
