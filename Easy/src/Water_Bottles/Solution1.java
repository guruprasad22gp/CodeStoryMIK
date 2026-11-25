package Water_Bottles;

public class Solution1 {
	public int numWaterBottles(int numBottles, int numExchange) {
		int total = numBottles;

		while (numBottles >= numExchange) {
			int temp = numBottles / numExchange;
			total += temp;
			numBottles = (numBottles / numExchange) + (numBottles % numExchange);
		}

		return total;
	}

	public static void main(String[] args) {
		int numBottles = 9;
		int numExchange = 3;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.numWaterBottles(numBottles, numExchange));
	}
}
