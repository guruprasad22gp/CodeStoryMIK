package Maximum_Ascending_Subarray_Sum;

public class Solution2 {
	public int maxIncSubarraySum(int arr[]) {
		int curr = arr[0];
		int max = curr;
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[i - 1]) {
				curr += arr[i];
			} else {
				curr = arr[i];
			}

			max = Math.max(curr, max);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 12, 25, 15, 13, 10, 11, 12 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.maxIncSubarraySum(nums));
	}
}
