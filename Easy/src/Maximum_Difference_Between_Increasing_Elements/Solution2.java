package Maximum_Difference_Between_Increasing_Elements;

public class Solution2 {
	public int maximumDifference(int[] nums) {
		int n = nums.length;
		int minEle = nums[0];
		int maxDiff = -1;
		int j = 1;

		while (j < n) {
			if (nums[j] > minEle) {
				maxDiff = Math.max(maxDiff, nums[j] - minEle);
			} else {
				minEle = nums[j];
			}
			j++;
		}

		return maxDiff;
	}

	public static void main(String[] args) {
		int[] nums = { 9, 4, 3, 2, 9 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.maximumDifference(nums));
	}
}