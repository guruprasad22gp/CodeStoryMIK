package Maximum_Value_of_an_Ordered_Triplet_I;

public class Solution3 {
	public long maximumTripletValue(int[] nums) {
		long result = 0;
		int maxDiff = 0;
		int maxI = 0;

		for (int i = 0; i < nums.length; i++) {
			result = Math.max(result, maxDiff * nums[i]);
			maxDiff = Math.max(maxDiff, maxI - nums[i]);
			maxI = Math.max(maxI, nums[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 12, 6, 1, 2, 7 };
		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.maximumTripletValue(nums));
	}
}