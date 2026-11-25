package Buy_Two_Chocolates;

import java.util.Arrays;

public class Solution1 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        
        money = money - prices[0] - prices[1];
        
        return money < 0? money + prices[0] + prices[1]: money;
    }
    
    public static void main(String[] args) {
    	int[] prices = {2,3,2};
    	int money = 3;
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.buyChoco(prices, money));
	}
}
