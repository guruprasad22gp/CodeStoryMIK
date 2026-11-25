package Make_Two_Arrays_Equal_by_Reversing_Subarrays;

import java.util.Arrays;

public class Solution1 {
	public boolean canBeEqual(int[] target, int[] arr) {
		Arrays.sort(target);
		Arrays.sort(arr);

		return Arrays.equals(target, arr);
	}

	public static void main(String[] args) {
		int[] target = { 1, 2, 3, 4 };
		int[] arr = { 2, 4, 1, 3 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.canBeEqual(target, arr));
	}
}
