package Range_Min_Max_Queries;

import java.util.ArrayList;

public class Solution1 {
	public ArrayList<ArrayList<Integer>> rangeMinMaxQueries(int[] arr, int[][] queries) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		SegmentTree st = new SegmentTree(arr);

		for (int[] x : queries) {
			if (x[0] == 1) {
				ArrayList<Integer> ans = new ArrayList<>();
				Node res = st.query(x[1], x[2]);
				ans.add(res.min);
				ans.add(res.max);
				result.add(ans);
			} else {
				st.update(x[1], x[2]);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 11, 3, 7, 5, 9, 1 };
		int queries[][] = { { 1, 0, 2 }, { 2, 3, 17 }, { 1, 0, 5 } };

		Solution1 sol1 = new Solution1();
		ArrayList<ArrayList<Integer>> res = sol1.rangeMinMaxQueries(arr, queries);
		for (ArrayList<Integer> ls : res) {
			System.out.println(ls);
		}
	}
}
