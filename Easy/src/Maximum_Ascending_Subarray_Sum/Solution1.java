package Maximum_Ascending_Subarray_Sum;

public class Solution1 {
	public int maxAscendingSum(int[] nums) {
		int maxSum = 0;
		int currSum = 0;
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			currSum = nums[i];
			for (int j = i + 1; j < n; j++) {
				if (nums[j] > nums[j - 1]) {
					currSum += nums[j];
				} else {
					break;
				}
			}

			maxSum = Math.max(maxSum, currSum);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[] nums = { 12, 25, 15, 13, 10, 11, 12 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxAscendingSum(nums));
	}
}
