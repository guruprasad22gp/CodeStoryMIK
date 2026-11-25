package Final_Array_State_After_K_Multiplication_Operations_I;

import java.util.PriorityQueue;

public class Solution2 {
	public int[] getFinalState(int[] nums, int k, int multiplier) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
				(a, b) -> nums[a] != nums[b] ? nums[a] - nums[b] : a - b);

		for (int i = 0; i < nums.length; i++) {
			queue.add(i);
		}

		while (k > 0) {
			int idx = queue.poll();
			nums[idx] = nums[idx] * multiplier;
			queue.add(idx);
			k--;
		}

		return nums;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 1, 3, 5, 6 };
		int k = 5;
		int multiplier = 2;

		Solution2 sol1 = new Solution2();
		int[] res = sol1.getFinalState(nums, k, multiplier);
		for (int ele : res) {
			System.out.print(ele + " ");
		}
	}
}