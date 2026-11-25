package Trapping_Rain_Water;

public class Solution1 {
	public int trap(int[] height) {
		int n = height.length;

		int maxLeft[] = new int[n];
		maxLeft[0] = height[0];
		for (int i = 1; i < n; i++) {
			maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
		}

		int maxRight[] = new int[n];
		maxRight[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			maxRight[i] = Math.max(maxRight[i + 1], height[i]);
		}

		int total = 0;
		for (int i = 1; i < n - 1; i++) {
			int min = Math.min(maxLeft[i - 1], maxRight[i + 1]);
			if (min <= height[i]) {
				continue;
			} else {
				total += min - height[i];
			}

		}
		return total;
	}

	public static void main(String[] args) {
		int[] height = { 1, 2, 3, 4 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.trap(height));
	}
}