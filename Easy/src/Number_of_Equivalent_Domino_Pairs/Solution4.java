package Number_of_Equivalent_Domino_Pairs;

class Solution4 {
	public int numEquivDominoPairs(int[][] dominoes) {
		int[] freq = new int[100];
		int count = 0;
		for (int[] x : dominoes) {
			if (x[0] > x[1]) {
				int t = x[0];
				x[0] = x[1];
				x[1] = t;
			}
			int num = x[0] * 10 + x[1];
			count += freq[num];
			freq[num]++;
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] dominoes = { { 1, 2 }, { 2, 1 }, { 3, 4 }, { 5, 6 } };
		Solution4 sol1 = new Solution4();
		System.out.println("Output: " + sol1.numEquivDominoPairs(dominoes));
	}
}