package Maximum_Value_of_an_Ordered_Triplet_I;

public class Solution2 {
	public long maximumTripletValue(int[] nums) {
		int n = nums.length;
		int[] leftMax = new int[n];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
		}

		int[] rightMax = new int[n];
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], nums[i + 1]);
		}
		long max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, (leftMax[i] - nums[i]) * rightMax[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.maximumTripletValue(nums));
	}
}