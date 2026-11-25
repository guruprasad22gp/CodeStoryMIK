package Koko_Eating_Bananas;

public class Solution1 {
	public int minEatingSpeed(int[] piles, int h) {
		int max = Integer.MIN_VALUE;
		for (int ele : piles) {
			max = Math.max(max, ele);
		}

		return binarySearch(1, max, h, piles);
	}

	private int binarySearch(int left, int right, int key, int[] arr) {
		while (left < right) {
			int mid = left + (right - left) / 2;

			if (canEatAllBananas(arr, mid, key)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	private boolean canEatAllBananas(int[] arr, int mid, int h) {
		int total = 0;

		for (int ele : arr) {
			total += (ele / mid);
			if (ele % mid != 0) {
				total += 1;
			}
		}

		System.out.println(total);

		return total <= h;
	}

	public static void main(String[] args) {
		int[] piles = { 3, 6, 7, 11 };
		int h = 8;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minEatingSpeed(piles, h));
	}
}
