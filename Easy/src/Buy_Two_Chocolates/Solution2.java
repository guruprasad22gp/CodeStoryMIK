package Buy_Two_Chocolates;

public class Solution2 {
    public int buyChoco(int[] prices, int money) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        
        for(int ele: prices) {
        	if(smallest > ele) {
        		secondSmallest = smallest;
        		smallest = ele;
        	} else if(secondSmallest > ele) {
        		secondSmallest = ele;
        	}
        }
        
        return money - secondSmallest - smallest < 0? money: money - secondSmallest - smallest;
    }
    
    public static void main(String[] args) {
    	int[] prices = {2,1,2};
    	int money = 3;
    	
    	Solution2 sol2 = new Solution2();
    	System.out.println("Output: " + sol2.buyChoco(prices, money));
	}
}
