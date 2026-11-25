package Find_Center_of_Star_Graph;

public class Solution2 {
	public int findCenter(int[][] edges) {
		if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
			return edges[0][0];
		} else {
			return edges[0][1];
		}
	}

	public static void main(String[] args) {
		int[][] edges = { { 1, 2 }, { 2, 3 }, { 4, 2 } };

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.findCenter(edges));
	}
}
