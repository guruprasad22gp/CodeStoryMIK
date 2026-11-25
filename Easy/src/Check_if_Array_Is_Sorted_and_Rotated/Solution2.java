package Check_if_Array_Is_Sorted_and_Rotated;

public class Solution2 {
	public boolean check(int[] nums) {
		int n = nums.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] <= nums[(i + 1) % n]) {
				count++;
			}
		}

		return count >= n - 1;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 5, 1, 2, 6 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.check(nums));
	}
}