package Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

public class Solution1 {
	public int maxProfit(int[] prices) {
		return solve(prices, 0, true);
	}

	private int solve(int[] prices, int day, boolean isBuy) {
		if (day >= prices.length) {
			return 0;
		}

		int profit = 0;
		if (isBuy) {
			int buy = solve(prices, day + 1, false) - prices[day];
			int notBuy = solve(prices, day + 1, isBuy);

			profit = Math.max(profit, Math.max(buy, notBuy));
		} else {
			int sell = prices[day] + solve(prices, day + 2, true);
			int notSell = solve(prices, day + 1, isBuy);
			profit = Math.max(profit, Math.max(sell, notSell));
		}

		return profit;
	}

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 0, 2 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxProfit(prices));
	}
}