package Count_Good_Triplets_in_an_Array;

import java.util.HashMap;

public class Solution {
	public long goodTriplets(int[] nums1, int[] nums2) {
		int n = nums2.length;

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(nums2[i], i);
		}

		long result = 0;

		SegmentTree st = new SegmentTree(n);
		st.update(0, 0, n - 1, map.get(nums1[0]));

		for (int i = 1; i < n; i++) {
			int idx = map.get(nums1[i]);

			long leftCommonCount = st.query(0, 0, n - 1, 0, idx);
			long leftNotCommonCount = i - leftCommonCount;
			long rightCount = n - 1 - idx;
			long rightCommonCount = rightCount - leftNotCommonCount;
			result += leftCommonCount * rightCommonCount;
			st.update(0, 0, n - 1, idx);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums1 = { 4, 0, 1, 3, 2 };
		int[] nums2 = { 4, 1, 0, 2, 3 };

		Solution sol1 = new Solution();
		System.out.println("Output: " + sol1.goodTriplets(nums1, nums2));

	}
}