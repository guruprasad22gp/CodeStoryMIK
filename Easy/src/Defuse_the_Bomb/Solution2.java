package Defuse_the_Bomb;

public class Solution2 {
	public int[] decrypt(int[] code, int k) {
		int n = code.length;
		int[] res = new int[n];
		int i = -1;
		int j = -1;
		if (k == 0) {
			return res;
		}
		if (k < 0) {
			i = n + k;
			j = n - 1;
		} else {
			i = 1;
			j = k;
		}

		int sum = 0;
		for (int start = i; start <= j; start++) {
			sum += code[start];
		}

		for (int m = 0; m < n; m++) {
			res[m] = sum;
			sum -= code[i % n];
			i++;
			j++;
			sum += code[j % n];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] code = { 5, 7, 1, 4 };
		int k = 3;

		Solution2 sol1 = new Solution2();
		int[] res = sol1.decrypt(code, k);

		for (int ele : res) {
			System.out.print(ele + " ");
		}
	}
}