package Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks;

public class Solution2 {
	public int minimumRecolors(String blocks, int k) {
		int min = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 0; i < k; i++) {
			if (blocks.charAt(i) == 'W') {
				count++;
			}
		}

		min = Math.min(min, count);
		for (int i = k; i < blocks.length(); i++) {
			if (blocks.charAt(i) == 'W') {
				count++;
			}

			if (blocks.charAt(i - k) == 'W') {
				count--;
			}

			min = Math.min(count, min);
		}

		return min;
	}

	public static void main(String[] args) {
		String blocks = "WBBWWBBWBW";
		int k = 7;
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.minimumRecolors(blocks, k));
	}
}
