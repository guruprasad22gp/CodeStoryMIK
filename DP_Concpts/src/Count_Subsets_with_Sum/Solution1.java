package Count_Subsets_with_Sum;

public class Solution1 {
	public int perfectSum(int[] arr, int target) {
		return solve(0, target, arr);
	}

	private int solve(int i, int target, int[] arr) {
		if (i == arr.length) {
			return target == 0 ? 1 : 0;
		}

		if (target < 0) {
			return 0;
		}

		int take = solve(i + 1, target - arr[i], arr);
		int skip = solve(i + 1, target, arr);
		return take + skip;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 5, 6, 7 };
		int target = 9;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.perfectSum(arr, target));
	}
}