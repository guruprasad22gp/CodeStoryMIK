package Number_Complement;

public class Solution1 {
	public int findComplement(int num) {
		int numBits = (int) (Math.log(num) / Math.log(2)) + 1;
		int xor = 1;

		for (int i = 0; i < numBits; i++) {
			num ^= xor;
			xor = (xor << 1);
		}

		return num;
	}

	public static void main(String[] args) {
		int num = 1;

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.findComplement(num));
	}
}