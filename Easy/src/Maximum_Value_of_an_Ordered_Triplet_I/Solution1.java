package Maximum_Value_of_an_Ordered_Triplet_I;

public class Solution1 {
	public long maximumTripletValue(int[] nums) {
		long max = 0;
		int n = nums.length;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					max = Math.max(max, (nums[i] - nums[j]) * (long) nums[k]);
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 12, 6, 1, 2, 7 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maximumTripletValue(nums));
	}
}