package Type_of_Triangle;

public class Solution1 {
	public String triangleType(int[] nums) {
		boolean valid = nums[0] + nums[1] > nums[2] && nums[0] + nums[2] > nums[1] && nums[1] + nums[2] > nums[0];
		if (!valid) {
			return "none";
		}

		if (nums[0] == nums[1] && nums[1] == nums[2]) {
			return "equilateral";
		} else if (nums[0] != nums[1] && nums[0] != nums[2] && nums[1] != nums[2]) {
			return "scalene";
		} else {
			return "isosceles";
		}
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 4 };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.triangleType(nums));
	}
}