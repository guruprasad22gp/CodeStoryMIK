package Check_If_N_and_Its_Double_Exist;

import java.util.HashSet;

public class Solution1 {
	public boolean checkIfExist(int[] arr) {
		HashSet<Integer> set = new HashSet<>();
		for (int ele : arr) {
			int j = ele * 2;
			if (set.contains(j)) {
				return true;
			}

			if (ele % 2 == 0 && set.contains(ele / 2)) {
				return true;
			}
			set.add(ele);
		}

		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 1, 7, 11 };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.checkIfExist(arr));
	}
}
