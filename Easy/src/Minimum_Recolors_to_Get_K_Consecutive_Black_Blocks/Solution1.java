package Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks;

public class Solution1 {
	public int minimumRecolors(String blocks, int k) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= blocks.length() - k; i++) {
			int count = 0;
			for (int j = i; j < i + k; j++) {
				if (blocks.charAt(j) == 'W') {
					count++;
				}
			}

			min = Math.min(count, min);
		}

		return min;
	}

	public static void main(String[] args) {
		String blocks = "WBBWWBBWBW";
		int k = 7;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minimumRecolors(blocks, k));
	}
}
