package Sum_of_All_Subset_XOR_Totals;

public class Solution1 {
	public static void main(String[] args) {
		int[] nums = { 1, 3 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.subsetXORSum(nums));

	}

	int total;

	public int subsetXORSum(int[] nums) {
		total = 0;
		solve(nums, 0, 0);
		return total;
	}

	private void solve(int[] nums, int index, int xor) {
		if (index == nums.length) {
			total += xor;
			return;
		}

		solve(nums, index + 1, xor ^ nums[index]);
		solve(nums, index + 1, xor);
	}
}
