package Number_Complement;

public class Solution2 {
	public int findComplement(int num) {
		int bitCount = (int) (Math.log(num) / Math.log(2)) + 1;
		int number = (1 << bitCount);
		return number - num - 1;
	}

	public static void main(String[] args) {
		int num = 2147483647;

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.findComplement(num));
	}
}