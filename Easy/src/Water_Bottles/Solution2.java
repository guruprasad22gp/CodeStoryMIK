package Water_Bottles;

public class Solution2 {
	public int numWaterBottles(int numBottles, int numExchange) {
		return numBottles + ((numBottles - 1) / (numExchange - 1));
	}

	public static void main(String[] args) {
		int numBottles = 9;
		int numExchange = 3;

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.numWaterBottles(numBottles, numExchange));
	}
}
