package Find_Building_Where_Alice_and_Bob_Can_Meet;

public class Solution1 {
	public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
		SegmentTree st = new SegmentTree(heights);
		int[] arr = new int[queries.length];
		int i = 0;
		for (int[] x : queries) {
			int startIndex = x[0];
			int endIndex = x[1];

			int minIndex = Math.min(startIndex, endIndex);
			int maxIndex = Math.max(startIndex, endIndex);

			if (minIndex == maxIndex || heights[minIndex] < heights[maxIndex]) {
				arr[i++] = maxIndex;
			} else {
				arr[i++] = st.binarySearch(maxIndex, heights[minIndex], heights);
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int[] heights = { 6, 4, 8, 5, 2, 7 };
		int[][] queries = { { 0, 1 }, { 0, 3 }, { 2, 4 }, { 3, 4 }, { 2, 2 } };
// 		index: 1, 3, 4, 4, 2
//		output: 8, 7, -1, 7, 8
//		Output Index: 2, 5, -1, 5, 2
		Solution1 sol1 = new Solution1();
		int[] ans = sol1.leftmostBuildingQueries(heights, queries);

		for (int ele : ans) {
			System.out.print(ele + " ");
		}
	}
}
