package Range_Maximum_Index_query_Part_2;

/*
Problem Statement: First Greater Element Value After Two Endpoints.
	1. You are given an integer array arr and a list of queries, where each query defines two indices left and right.
	2. For each query, your task is to first find the maximum value between the two specific elements at the given indices, calculated as maxVal = Math.max(arr[left], arr[right]). 
	3. Once you have this maximum value, you must look into the remaining portion of the array to the right—specifically from index Math.max(left, right) + 1 to the end of the array—and find the very first element that is strictly greater than maxVal.
	4. If a valid element exists in this suffix, you must return its actual value (the element itself). If no such element is found, you should return -1.

Examples
Example 1
Input: arr = [6, 4, 8, 5, 2, 7], queries = [[0, 1]]
Output: [8]

Explanation:
	1. The indices are 0 and 1, with values arr[0] = 6 and arr[1] = 4. 
 	2. The maximum between them is Math.max(6, 4) = 6. The remaining suffix to the right of index 1 starts at index 2 ([8, 5, 2, 7]). 
	3. The first element strictly greater than 6 is 8.

Example 2
Input: arr = [6, 4, 8, 5, 2, 7], queries = [[2, 4]]
Output: [-1]

Explanation:
	1. The indices are 2 and 4, with values arr[2] = 8 and arr[4] = 2. 
	2. The maximum between them is Math.max(8, 2) = 8. The remaining suffix to the right of index 4 starts at index 5 ([7]). 
	3. There are no elements greater than 8 in this suffix, so the result is -1.

*/
import java.util.ArrayList;

public class Solution {
	ArrayList<Integer> find(int[] arr, int[][] queries) {
		ArrayList<Integer> result = new ArrayList<>();
		SegmentTree st = new SegmentTree(arr);

		for (int[] x : queries) {
			int minIndex = Math.min(x[0], x[1]);
			int maxIndex = Math.max(x[0], x[1]);

			result.add(st.binarySearch(maxIndex, Math.max(arr[minIndex], arr[maxIndex]), arr));
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 3, 6, 6, 7, 4, 1, 6 };
		int[][] queries = { { 1, 6 }, { 0, 3 }, { 0, 2 }, { 3, 5 }, { 2, 3 } };
//Output; [6, 7, 7, -1, 7]
		Solution sol1 = new Solution();
		System.out.println("Output: " + sol1.find(arr, queries));
	}
}
