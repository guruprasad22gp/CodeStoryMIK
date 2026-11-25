package Constrained_Subsequence_Sum;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {
	public int constrainedSubsetSum(int[] nums, int k) {
		int total = Integer.MIN_VALUE;
		int[] dp = new int[nums.length];
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			while (!dq.isEmpty() && dq.peekFirst() < i - k) {
				dq.removeFirst();
			}

			int best = dq.isEmpty() ? 0 : Math.max(0, dp[dq.peekFirst()]);
			dp[i] = nums[i] + best;
			total = Math.max(total, dp[i]);
			while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
				dq.removeLast();
			}

			dq.addLast(i);
		}

		return total;

	}

	public static void main(String[] args) {
		int[] nums = { 10, 2, -10, 5, 20 };
		int k = 1;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.constrainedSubsetSum(nums, k));
	}
}