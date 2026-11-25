package Longest_Harmonious_Subsequence;

import java.util.HashMap;

public class Solution2 {
	public int findLHS(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int ele : nums) {
			map.put(ele, map.getOrDefault(ele, 0) + 1);
		}
		int maxLen = 0;
		for (int ele : map.keySet()) {
			int minFreq = map.containsKey(ele) ? map.get(ele) : 0;
			int maxFreq = map.containsKey(ele + 1) ? map.get(ele + 1) : 0;
			if (minFreq != 0 && maxFreq != 0) {
				maxLen = Math.max(maxLen, maxFreq + minFreq);
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.findLHS(nums));
	}
}
