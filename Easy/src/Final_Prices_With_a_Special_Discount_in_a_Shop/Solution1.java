package Final_Prices_With_a_Special_Discount_in_a_Shop;

public class Solution1 {
	public int[] finalPrices(int[] prices) {
		int n = prices.length;

		for (int i = 0; i < n - 1; i++) {
			int price = prices[i];
			for (int j = i + 1; j < n; j++) {
				if (prices[j] <= price) {
					prices[i] = price - prices[j];
					break;
				}
			}
		}

		return prices;
	}

	public static void main(String[] args) {
		int[] prices = { 10, 1, 1, 6 };
		Solution1 sol1 = new Solution1();
		int[] res = sol1.finalPrices(prices);
		for (int ele : res) {
			System.out.print(ele + " ");
		}
	}
}
