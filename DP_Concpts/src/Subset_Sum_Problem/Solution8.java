package Subset_Sum_Problem;

public class Solution8 {
	boolean isSubsetSum(int arr[], int sum) {
		int n = arr.length;
		boolean[] prev = new boolean[sum + 1];
		prev[0] = true;

		for (int i = 1; i <= n; i++) {
			boolean[] curr = new boolean[sum + 1];
			for (int j = 0; j <= sum; j++) {
				boolean take = false;

				if (arr[i - 1] <= j) {
					take |= prev[j - arr[i - 1]];
				}
				boolean skip = prev[j];
				curr[j] = skip | take;
			}
			prev = curr;
		}

		return prev[sum];
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		int sum = 6;

		Solution8 sol1 = new Solution8();
		System.out.println("Output: " + sol1.isSubsetSum(arr, sum));
	}
}
