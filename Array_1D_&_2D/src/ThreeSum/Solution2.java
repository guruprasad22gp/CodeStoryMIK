package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < n - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int j = i + 1;
			int k = n - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					List<Integer> ans = new ArrayList<>();
					ans.add(nums[i]);
					ans.add(nums[j]);
					ans.add(nums[k]);
					res.add(ans);
					j++;
					k--;

					while (j < k && nums[j] == nums[j - 1]) {
						j++;
					}

					while (k > j && nums[k] == nums[k + 1]) {
						k--;
					}
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		Solution2 sol1 = new Solution2();
		List<List<Integer>> res = sol1.threeSum(nums);

		for (List<Integer> ls : res) {
			System.out.println(ls);
		}
	}
}
