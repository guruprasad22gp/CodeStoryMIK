package Sum_of_All_Subset_XOR_Totals;

public class Solution3 {
	public static void main(String[] args) {
		int[] nums = { 1, 3 };
		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.subsetXORSum(nums));

	}

	public int subsetXORSum(int[] nums) {
		int or = 0;
		for (int num : nums) {
			or |= num;
		}

		return or << nums.length - 1;
	}
}
