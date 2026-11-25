package Find_All_K_Distant_Indices_in_an_Array;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
		List<Integer> res = new ArrayList<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] == key) {
				int start = Math.max(Math.max(i - k, 0), res.isEmpty() ? 0 : res.getLast() + 1);
				int end = Math.min(i + k, n - 1);
				for (int j = start; j <= end; j++) {
					res.add(j);
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 2, 2, 2 };
		int key = 2;
		int k = 2;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.findKDistantIndices(nums, key, k));
	}
}