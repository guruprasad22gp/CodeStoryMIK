package Subset_Sum_Problem;

public class Soluiton5 {
	int n;

	boolean isSubsetSum(int arr[], int sum) {
		n = arr.length;
		return solve(n, sum, arr);
	}

	private boolean solve(int i, int sum, int[] arr) {
		if (sum == 0) {
			return true;
		}

		if (i == 0) {
			return false;
		}

		boolean take = false;
		if (arr[i - 1] <= sum) {
			take |= solve(i - 1, sum - arr[i - 1], arr);
		}

		boolean skip = solve(i - 1, sum, arr);
		return skip | take;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		int sum = 6;

		Soluiton5 sol1 = new Soluiton5();
		System.out.println("Output: " + sol1.isSubsetSum(arr, sum));
	}
}
