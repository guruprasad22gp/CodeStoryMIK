package Partitions_with_Given_Difference;

public class Solution2 {
	public int countPartitions(int[] arr, int diff) {
		int sum = 0;
		for (int ele : arr) {
			sum += ele;
		}

		if ((sum + diff) % 2 != 0) {
			return 0;
		}

		int target = (sum + diff) / 2;

		return solve(0, target, arr);
	}

	private int solve(int i, int target, int[] arr) {
		if (i == arr.length) {
			return target == 0 ? 1 : 0;
		}

		int skip = solve(i + 1, target, arr);
		int take = 0;
		if (arr[i] <= target) {
			take = solve(i + 1, target - arr[i], arr);
		}
		return skip + take;
	}

	public static void main(String[] args) {
		int arr[] = { 5, 2, 6, 4 };
		int diff = 3;

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.countPartitions(arr, diff));
	}
}
