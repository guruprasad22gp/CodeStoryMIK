package Find_Center_of_Star_Graph;

public class Solution1 {
	public int findCenter(int[][] edges) {
		int n = edges.length;
		int[] inDegree = new int[n + 1];
		for (int[] x : edges) {
			int v = x[1] - 1;
			int u = x[0] - 1;
			inDegree[v]++;
			inDegree[u]++;
		}

		for (int i = 0; i <= n; i++) {
			if (inDegree[i] > 1) {
				return i + 1;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		int[][] edges = { { 1, 2 }, { 2, 3 }, { 4, 2 } };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.findCenter(edges));
	}
}
