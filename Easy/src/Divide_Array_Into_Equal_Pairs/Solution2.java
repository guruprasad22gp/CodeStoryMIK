package Divide_Array_Into_Equal_Pairs;

import java.util.HashSet;

public class Solution2 {
	public boolean divideArray(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int ele : nums) {
			if (set.contains(ele)) {
				set.remove(ele);
			} else {
				set.add(ele);
			}
		}

		return set.size() == 0;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 3, 2, 2, 2 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.divideArray(nums));
	}
}
