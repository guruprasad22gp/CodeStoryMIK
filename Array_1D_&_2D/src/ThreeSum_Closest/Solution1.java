package ThreeSum_Closest;

public class Solution1 {
	public int threeSumClosest(int[] nums, int target) {
		int n = nums.length;
		int closest = 0;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					closest = Math.abs(target - sum) <= diff ? sum : closest;
					diff = Math.min(diff, Math.abs(target - sum));

				}
			}
		}
		return closest;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 12, 7, 8, -5 };
		int target = 16;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.threeSumClosest(nums, target));
	}
}