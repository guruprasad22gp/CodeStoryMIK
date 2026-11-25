package Final_Array_State_After_K_Multiplication_Operations_I;

import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
	int num;
	int index;

	Pair(int num, int index) {
		this.num = num;
		this.index = index;
	}

	@Override
	public int compareTo(Pair o) {
		if (this.num == o.num) {
			return this.index - o.index;
		}

		return this.num - o.num;
	}
}

public class Solution1 {
	public int[] getFinalState(int[] nums, int k, int multiplier) {
		PriorityQueue<Pair> queue = new PriorityQueue<>();
		for (int i = 0; i < nums.length; i++) {
			queue.add(new Pair(nums[i], i));
		}

		while (k > 0) {
			Pair temp = queue.poll();
			queue.add(new Pair(temp.num * multiplier, temp.index));
			k--;
		}

		while (!queue.isEmpty()) {
			Pair temp = queue.poll();
			nums[temp.index] = temp.num;
		}

		return nums;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 1, 3, 5, 6 };
		int k = 5;
		int multiplier = 2;

		Solution1 sol1 = new Solution1();
		int[] res = sol1.getFinalState(nums, k, multiplier);
		for (int ele : res) {
			System.out.print(ele + " ");
		}
	}
}