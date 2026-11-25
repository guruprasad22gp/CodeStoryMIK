package Count_Subsets_with_Sum;

public class Solution8 {
	public int perfectSum(int[] arr, int target) {
		int n = arr.length;
		int[] prev = new int[target + 1];
		prev[0] = 1;

		for (int i = 1; i <= n; i++) {
			int[] curr = new int[target + 1];
			for (int j = 0; j <= target; j++) {

				int skip = prev[j];
				int take = 0;
				if (arr[i - 1] <= j) {
					take = prev[j - arr[i - 1]];
				}
				curr[j] = skip + take;
			}
			prev = curr;
		}
		return prev[target];
	}

	public static void main(String[] args) {
		int arr[] = { 5, 2, 3, 10, 6, 8 };
		int target = 10;

		Solution8 sol1 = new Solution8();
		System.out.println("Output: " + sol1.perfectSum(arr, target));
	}
}