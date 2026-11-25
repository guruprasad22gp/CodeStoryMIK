package Partition_Equal_Subset_Sum;

public class Solution8 {
	public boolean canPartition(int[] nums) {
		int n = nums.length;
		int sum = 0;
		for (int ele : nums) {
			sum += ele;
		}

		if (sum % 2 == 1) {
			return false;
		}

		sum /= 2;
		boolean[] prev = new boolean[sum + 1];
		prev[0] = true;

		for (int i = 1; i <= n; i++) {
			boolean[] curr = new boolean[sum + 1];
			curr[0] = true;
			for (int j = 0; j <= sum; j++) {
				boolean take = false;
				if (nums[i - 1] <= j) {
					take |= prev[j - nums[i - 1]];
				}
				boolean skip = prev[j];
				curr[j] = skip | take;
			}
			prev = curr;
		}

		return prev[sum];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 11, 5 };
		Solution8 sol1 = new Solution8();
		System.out.println("Output: " + sol1.canPartition(arr));
	}
}