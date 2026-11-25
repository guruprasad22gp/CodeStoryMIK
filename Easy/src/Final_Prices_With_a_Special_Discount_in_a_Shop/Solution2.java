package Final_Prices_With_a_Special_Discount_in_a_Shop;

import java.util.Stack;

public class Solution2 {
	public int[] finalPrices(int[] prices) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
				prices[stack.pop()] -= prices[i];
			}
			stack.add(i);
		}

		return prices;
	}

	public static void main(String[] args) {
		int[] prices = { 10, 1, 1, 6 };
		Solution2 sol1 = new Solution2();
		int[] res = sol1.finalPrices(prices);
		for (int ele : res) {
			System.out.print(ele + " ");
		}
	}
}
