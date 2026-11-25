package Take_Gifts_From_the_Richest_Pile;

import java.util.PriorityQueue;

public class Solution1 {
	public long pickGifts(int[] gifts, int k) {
		long totalSum = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
		for (int ele : gifts) {
			queue.add(ele);
			totalSum += ele;
		}

		long sum = 0;
		while (k > 0) {
			int num = queue.poll();
			int sqrt = (int) (num - Math.floor(Math.sqrt(num)));
			sum += sqrt;
			queue.add(num - sqrt);
			k--;
		}

		return totalSum - sum;
	}

	public static void main(String[] args) {
		int[] gifts = { 25, 64, 9, 4, 100 };
		int k = 4;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.pickGifts(gifts, k));
	}
}
