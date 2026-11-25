package Partitions_with_Given_Difference;

public class Solution5 {
	public int countPartitions(int[] arr, int diff) {
		int sum = 0;
		for (int ele : arr) {
			sum += ele;
		}

		if ((sum + diff) % 2 != 0) {
			return 0;
		}

		int target = (sum + diff) / 2;
		int n = arr.length;
		int[] prev = new int[target + 1];
		prev[0] = 1;
		for (int i = n - 1; i >= 0; i--) {
			int[] curr = new int[target + 1];
			for (int j = 0; j <= target; j++) {
				int skip = prev[j];
				int take = 0;
				if (arr[i] <= j) {
					take = prev[j - arr[i]];
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

		Solution5 sol1 = new Solution5();
		System.out.println("Output: " + sol1.countPartitions(arr, diff));
	}
}
