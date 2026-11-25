package Partitions_with_Given_Difference;

public class Solution1 {
	public int countPartitions(int[] arr, int diff) {
		int sum = 0;
		for (int ele : arr) {
			sum += ele;
		}

		if ((sum + diff) % 2 != 0) {
			return 0;
		}

		int target = (sum + diff) / 2;
		int[] prev = new int[target + 1];
		prev[0] = 1;
		int n = arr.length;
		for (int i = 1; i <= n; i++) {
			int[] curr = new int[target + 1];
			for (int j = 0; j <= target; j++) {
				int skip = prev[j];
				int take = 0;
				if (arr[i - 1] <= j) {
					take = prev[j - arr[i - 1]];
				}

				curr[j] = take + skip;
			}
			prev = curr;
		}

		return prev[target];
	}

	public static void main(String[] args) {
		int arr[] = { 5, 2, 6, 4 };
		int diff = 3;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.countPartitions(arr, diff));
	}
}
