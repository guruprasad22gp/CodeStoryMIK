package Subset_Sum_Problem;

public class Solution4 {
	boolean isSubsetSum(int arr[], int sum) {
		int n = arr.length;
		boolean[] prev = new boolean[sum + 1];
		prev[0] = true;

		for (int i = n - 1; i >= 0; i--) {
			boolean[] curr = new boolean[sum + 1];
			for (int j = 0; j <= sum; j++) {
				boolean take = false;
				if (arr[i] <= j) {
					take |= prev[j - arr[i]];
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

		Solution4 sol1 = new Solution4();
		System.out.println("Output: " + sol1.isSubsetSum(arr, sum));
	}
}
