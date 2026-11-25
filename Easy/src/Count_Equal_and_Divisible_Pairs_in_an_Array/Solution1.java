package Count_Equal_and_Divisible_Pairs_in_an_Array;

public class Solution1 {
	public int countPairs(int[] nums, int k) {
		int count = 0;
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[i] == nums[j] && (i * j) % k == 0) {
					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1, 2, 2, 2, 1, 3 };
		int k = 2;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.countPairs(nums, k));
	}
}