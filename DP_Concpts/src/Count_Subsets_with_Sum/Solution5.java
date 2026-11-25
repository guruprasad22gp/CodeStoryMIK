package Count_Subsets_with_Sum;

public class Solution5 {
	public int perfectSum(int[] arr, int target) {
		return solve(arr.length, target, arr);
	}

	private int solve(int i, int target, int[] arr) {
		if (i == 0) {
			return target == 0 ? 1 : 0;
		}

		if (target < 0) {
			return 0;
		}

		int take = solve(i - 1, target - arr[i - 1], arr);
		int skip = solve(i - 1, target, arr);
		return take + skip;
	}

	public static void main(String[] args) {
		int arr[] = { 5, 2, 3, 10, 6, 8 };
		int target = 10;

		Solution5 sol1 = new Solution5();
		System.out.println("Output: " + sol1.perfectSum(arr, target));
	}
}