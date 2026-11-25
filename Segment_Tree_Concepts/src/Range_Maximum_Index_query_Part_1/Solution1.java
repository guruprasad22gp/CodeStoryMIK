package Range_Maximum_Index_query_Part_1;

import java.util.ArrayList;

public class Solution1 {
	public static void main(String[] args) {
		int[] arr = { 3, 7, 5, 9, 1, 11 };
		int[][] queries = { { 0, 2 }, { 0, 5 } };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.rangeMinMaxQueries(arr, queries));
	}

	public ArrayList<Integer> rangeMinMaxQueries(int[] arr, int[][] queries) {
		SegmentTree st = new SegmentTree(arr);
		ArrayList<Integer> result = new ArrayList<>();
		for (int[] x : queries) {
			result.add(st.query(x[0], x[1], arr));
		}

		return result;
	}
}
