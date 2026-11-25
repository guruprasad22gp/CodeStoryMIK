package Count_Largest_Group;

public class Solution2 {
	public int countLargestGroup(int n) {
		int max = 0;
		int count = 0;
		int[] freq = new int[37];
		for (int i = 1; i <= n; i++) {
			int digitSum = find(i);
			freq[digitSum]++;
			if (freq[digitSum] > max) {
				max = freq[digitSum];
				count = 1;
			} else if (max == freq[digitSum]) {
				count++;
			}
		}

		return count;
	}

	private int find(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		int n = 143;
		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.countLargestGroup(n));
	}
}