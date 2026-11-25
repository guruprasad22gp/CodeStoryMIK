package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < n - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < n - 1; j++) {
				if (j - 1 > i && nums[j] == nums[j - 1]) {
					continue;
				}

				for (int k = j + 1; k < n; k++) {
					if (k - 1 > j && nums[k] == nums[k - 1]) {
						continue;
					}

					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> ans = new ArrayList<>();
						ans.add(nums[i]);
						ans.add(nums[j]);
						ans.add(nums[k]);
						res.add(ans);
					}
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		Solution1 sol1 = new Solution1();
		List<List<Integer>> res = sol1.threeSum(nums);

		for (List<Integer> ls : res) {
			System.out.println(ls);
		}
	}
}
