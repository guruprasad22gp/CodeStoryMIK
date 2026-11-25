package Make_Two_Arrays_Equal_by_Reversing_Subarrays;

import java.util.HashMap;

public class Solution2 {
	public boolean canBeEqual(int[] target, int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int ele : target) {
			map.put(ele, map.getOrDefault(ele, 0) + 1);
		}

		for (int ele : arr) {
			if (!map.containsKey(ele)) {
				return false;
			}

			map.put(ele, map.get(ele) - 1);

			if (map.get(ele) == 0) {
				map.remove(ele);
			}
		}

		return map.size() == 0;
	}

	public static void main(String[] args) {
		int[] target = { 1, 2, 3, 4 };
		int[] arr = { 2, 4, 1, 3 };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.canBeEqual(target, arr));
	}
}
