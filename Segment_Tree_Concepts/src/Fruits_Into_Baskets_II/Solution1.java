package Fruits_Into_Baskets_II;

public class Solution1 {
	public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
		int n = fruits.length;
		boolean visited[] = new boolean[n];
		int result = 0;
		for (int i = 0; i < n; i++) {
			int first = fruits[i];
			boolean gotBasket = false;
			for (int j = 0; j < n; j++) {
				if (first <= baskets[j] && !visited[j]) {
					visited[j] = true;
					gotBasket = true;
					break;
				}
			}

			if (!gotBasket) {
				result++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] fruits = { 4 };
		int[] baskets = { 4 };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.numOfUnplacedFruits(fruits, baskets));
	}
}
