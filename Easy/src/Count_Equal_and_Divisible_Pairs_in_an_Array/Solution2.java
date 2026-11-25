package Count_Equal_and_Divisible_Pairs_in_an_Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution2 {
	public int countPairs(int[] nums, int k) {
		int n = nums.length;
		int result = 0;

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.computeIfAbsent(nums[i], j -> new ArrayList<>()).add(i);
		}

		HashSet<Integer> set = new HashSet<>();
		for (int f = 1; f * f <= k; f++) {
			if (k % f == 0) {
				set.add(f);
				set.add(k / f);
			}
		}

		for (ArrayList<Integer> indices : map.values()) {
			HashMap<Integer, Integer> factors = new HashMap<>();
			for (int i : indices) {
				int GCD = gcd(i, k);
				int j = k / GCD;
				result += factors.getOrDefault(j, 0);
				for (int f : set) {
					if (i % f == 0) {
						factors.put(f, factors.getOrDefault(f, 0) + 1);
					}
				}
			}
		}

		return result;
	}

	private int gcd(int a, int b) {
		while (b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int k = 1;
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.countPairs(nums, k));
	}
}