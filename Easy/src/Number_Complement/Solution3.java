package Number_Complement;

public class Solution3 {
	public int findComplement(int num) {
		int i = 0;
		int complement = 0;
		while (num > 0) {
			if ((num & 1) == 0) {
				complement |= (1 << i);
			}
			num >>= 1;
			i++;
		}

		return complement;
	}

	public static void main(String[] args) {
		int num = 2;

		Solution3 sol1 = new Solution3();
		System.out.println("Output: " + sol1.findComplement(num));
	}
}