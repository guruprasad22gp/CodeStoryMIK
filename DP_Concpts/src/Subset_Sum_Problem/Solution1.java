package Subset_Sum_Problem;

public class Solution1 {
	int n;

	boolean isSubsetSum(int arr[], int sum) {
		n = arr.length;
		return solve(0, sum, arr);
	}

	private boolean solve(int i, int sum, int[] arr) {
		if (sum == 0) {
			return true;
		}

		if (i >= n) {
			return false;
		}

		boolean take = false;
		if (arr[i] <= sum) {
			take |= solve(i + 1, sum - arr[i], arr);
		}

		boolean skip = solve(i + 1, sum, arr);

		return skip | take;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		int sum = 6;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.isSubsetSum(arr, sum));
	}
}
