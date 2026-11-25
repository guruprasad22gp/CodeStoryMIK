package Sliding_Window_Maximum;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution2 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> dq = new ArrayDeque<>();
		int[] res = new int[nums.length - k + 1];
		int idx = 0;
		for (int i = 0; i < nums.length; i++) {
			while (!dq.isEmpty() && dq.getFirst() <= i - k) {
				dq.removeFirst();
			}

			while (!dq.isEmpty() && nums[i] >= nums[dq.getLast()]) {
				dq.removeLast();
			}

			dq.addLast(i);

			if (i >= k - 1) {
				res[idx++] = nums[dq.getFirst()];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;

		Solution2 sol1 = new Solution2();
		int[] res = sol1.maxSlidingWindow(nums, k);
		System.out.println("Output: " + Arrays.toString(res));
	}
}