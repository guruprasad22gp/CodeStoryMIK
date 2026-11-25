package Number_of_Equivalent_Domino_Pairs;

import java.util.HashMap;

public class Solution2 {
	public int numEquivDominoPairs(int[][] dominoes) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int[] x : dominoes) {
			if (x[0] > x[1]) {
				int t = x[0];
				x[0] = x[1];
				x[1] = t;
			}
			String s = x[0] + "_" + x[1];
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		int count = 0;
		for (int ele : map.values()) {
			if (ele > 1) {
				count += (ele * (ele - 1)) / 2;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[][] dominoes = { { 1, 2 }, { 2, 1 }, { 3, 4 }, { 5, 6 } };
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.numEquivDominoPairs(dominoes));

	}
}
