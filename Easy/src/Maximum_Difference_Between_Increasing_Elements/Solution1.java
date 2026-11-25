package Maximum_Difference_Between_Increasing_Elements;

public class Solution1 {
	public int maximumDifference(int[] nums) {
		int max = -1;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[i] < nums[j]) {
					max = Math.max(max, nums[j] - nums[i]);
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 9, 4, 3, 2 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maximumDifference(nums));
	}
}