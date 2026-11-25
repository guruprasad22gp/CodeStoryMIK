package Partition_Equal_Subset_Sum;

public class Solution1 {
	int n;

	public boolean canPartition(int[] nums) {
		n = nums.length;
		int sum = 0;
		for (int ele : nums) {
			sum += ele;
		}

		if (sum % 2 != 0) {
			return false;
		}

		return solve(0, sum / 2, nums);
	}

	private boolean solve(int i, int target, int[] arr) {
		if (target == 0) {
			return true;
		}

		if (i >= n) {
			return false;
		}

		boolean take = false;
		if (arr[i] <= target) {
			take |= solve(i + 1, target - arr[i], arr);
		}
		boolean skip = solve(i + 1, target, arr);
		return skip | take;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 11, 5 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.canPartition(arr));
	}
}