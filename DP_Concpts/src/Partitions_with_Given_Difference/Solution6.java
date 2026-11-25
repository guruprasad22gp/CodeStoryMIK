package Partitions_with_Given_Difference;

public class Solution6 {
	public int countPartitions(int[] arr, int diff) {
		int sum = 0;
		for (int ele : arr) {
			sum += ele;
		}

		if ((sum + diff) % 2 != 0) {
			return 0;
		}
		int n = arr.length;
		int target = (sum + diff) / 2;
		return solve(n, target, arr);
	}

	private int solve(int i, int target, int[] arr) {
		if (i == 0) {
			return target == 0 ? 1 : 0;
		}

		int skip = solve(i - 1, target, arr);
		int take = 0;
		if (arr[i - 1] <= target) {
			take = solve(i - 1, target - arr[i - 1], arr);
		}

		return take + skip;
	}

	public static void main(String[] args) {
		int arr[] = { 5, 2, 6, 4 };
		int diff = 3;

		Solution6 sol1 = new Solution6();
		System.out.println("Output: " + sol1.countPartitions(arr, diff));
	}
}
