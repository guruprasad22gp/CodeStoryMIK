package Maximum_Difference_Between_Adjacent_Elements_in_a_Circular_Array;

public class Solution1 {
	public int maxAdjacentDistance(int[] nums) {
		int n = nums.length;
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, Math.abs(nums[i] - nums[(i + 1) % n]));
		}

		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 4 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxAdjacentDistance(nums));
	}
}