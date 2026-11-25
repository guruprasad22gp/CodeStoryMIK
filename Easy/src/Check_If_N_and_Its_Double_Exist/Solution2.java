package Check_If_N_and_Its_Double_Exist;

public class Solution2 {
	public boolean checkIfExist(int[] arr) {
		boolean[] seen = new boolean[4001];
		for (int ele : arr) {
			if (seen[ele * 2 + 2000] || (ele % 2 == 0 && seen[ele / 2 + 2000])) {
				return true;
			}

			seen[2000 + ele] = true;
		}

		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 2, 5, 3 };

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.checkIfExist(arr));
	}
}
