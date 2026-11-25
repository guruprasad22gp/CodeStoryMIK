package Block_Placement_Queries;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution1 {
	public List<Boolean> getResults(int[][] queries) {
		List<Boolean> result = new ArrayList<>();
		Set<Integer> set = new TreeSet<>();
		set.add(0);

		for (int[] x : queries) {
			if (x[0] == 1) {
				set.add(x[1]);
			} else {
				int end = x[1];
				int blockSize = x[2];

				int prev = 0;
				boolean found = false;

				for (int blockPoint : set) {
					if (blockPoint > end) {
						break;
					}

					if (blockPoint - prev >= blockSize) {
						found = true;
						break;
					}

					prev = blockPoint;
				}

				if (!found) {
					if (end - prev >= blockSize) {
						found = true;
					}
				}

				result.add(found);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] queries = { { 1, 2 }, { 2, 3, 3 }, { 2, 3, 1 }, { 2, 2, 2 } };
		Solution1 sol1 = new Solution1();

		System.out.println("Output: " + sol1.getResults(queries));
	}
}
