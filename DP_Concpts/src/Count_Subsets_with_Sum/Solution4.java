package Count_Subsets_with_Sum;

public class Solution4 {
	int perfectSum(int[] arr, int target) {
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
				curr[j] = skip + take;
			}

			prev = curr;
		}

		return prev[target];
	}

	public static void main(String[] args) {
		int arr[] = { 5, 7, 8 };
		int target = 15;

		Solution4 sol1 = new Solution4();
		System.out.println("Output: " + sol1.perfectSum(arr, target));
	}
}