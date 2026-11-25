package Sum_of_All_Subset_XOR_Totals;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	public static void main(String[] args) {
		int[] nums = { 1, 3 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.subsetXORSum(nums));

	}

	List<List<Integer>> allSubSets;

	public int subsetXORSum(int[] nums) {
		List<Integer> currSub = new ArrayList<>();
		allSubSets = new ArrayList<>();

		solve(nums, 0, currSub);

		int total = 0;
		for (List<Integer> ls : allSubSets) {
			int xor = 0;
			for (int num : ls) {
				xor ^= num;
			}

			System.out.println(ls);
			total += xor;
		}

		return total;
	}

	private void solve(int[] nums, int index, List<Integer> currSub) {
		if (index == nums.length) {
			allSubSets.add(new ArrayList<>(currSub));
			return;
		}

		currSub.add(nums[index]);
		solve(nums, index + 1, currSub);
		currSub.removeLast();
		solve(nums, index + 1, currSub);
	}
}
