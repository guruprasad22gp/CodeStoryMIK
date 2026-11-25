package Defuse_the_Bomb;

public class Solution1 {
	public int[] decrypt(int[] code, int k) {
		int n = code.length;
		int[] res = new int[n];

		if (k == 0) {
			for (int i = 0; i < n; i++) {
				res[i] = 0;
			}
		} else if (k > 0) {
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int start = i + 1; start <= i + k; start++) {
					sum += code[start % n];
				}
				res[i] = sum;
			}
		} else {
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = i - 1; j >= i + k; j--) {
					int idx = (j + n) % n;
					sum += code[idx];
				}
				res[i] = sum;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] code = { 2, 4, 9, 3 };
		int k = 0;

		Solution1 sol1 = new Solution1();
		int[] res = sol1.decrypt(code, k);

		for (int ele : res) {
			System.out.print(ele + " ");
		}
	}
}