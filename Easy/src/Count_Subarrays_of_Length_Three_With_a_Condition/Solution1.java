package Count_Subarrays_of_Length_Three_With_a_Condition;

public class Solution1 {
	public int countSubarrays(int[] nums) {
		int count = 0;

		for (int i = 1; i < nums.length - 1; i++) {
			if (2 * (nums[i - 1] + nums[i + 1]) == nums[i]) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 4, 1 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.countSubarrays(nums));
	}
}
