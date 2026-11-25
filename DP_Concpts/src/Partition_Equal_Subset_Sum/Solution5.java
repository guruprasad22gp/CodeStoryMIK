package Partition_Equal_Subset_Sum;

public class Solution5 {
	int n;

	public boolean canPartition(int[] nums) {
		n = nums.length;
		int sum = 0;
		for (int ele : nums) {
			sum += ele;
		}

		if (sum % 2 == 1) {
			return false;
		}

		sum /= 2;

		return solve(n, sum, nums);
	}

	private boolean solve(int i, int sum, int[] nums) {
		if (sum == 0) {
			return true;
		}

		if (i == 0) {
			return false;
		}

		boolean take = false;
		if (nums[i - 1] <= sum) {
			take |= solve(i - 1, sum - nums[i - 1], nums);
		}

		boolean skip = solve(i - 1, sum, nums);
		return skip | take;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 11, 5 };
		Solution5 sol1 = new Solution5();
		System.out.println("Output: " + sol1.canPartition(arr));
	}
}