package Number_of_Ways_to_Assign_Edge_Weights_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
	List<List<Integer>> adj;
	int[][] parent;
	int[] depths;
	int cols;
	int MOD = 1_000_000_007;
	int n;

	public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
		n = edges.length + 1;
		adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int[] x : edges) {
			int u = x[0];
			int v = x[1];
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		cols = (int) (Math.log(n + 1) / Math.log(2)) + 1;
		parent = new int[n + 1][cols];
		for (int[] x : parent) {
			Arrays.fill(x, -1);
		}
		depths = new int[n + 1];
		DFS(1, -1, 0);
		buildAncestor();

		long[] pow2 = new long[n + 1];
		pow2[0] = 1;
		for (int i = 1; i <= n; i++) {
			pow2[i] = (2 * pow2[i - 1]) % MOD;
		}
		int idx = 0;
		int q = queries.length;
		int[] res = new int[q];
		for (int[] x : queries) {
			int u = x[0];
			int v = x[1];
			int lca = getLCA(u, v);
			int d = depths[u] + depths[v] - 2 * depths[lca];
			res[idx++] = d == 0 ? 0 : (int) pow2[d - 1];
		}
		return res;
	}

	private int getLCA(int u, int v) {
		if (depths[u] != depths[v]) {
			if (depths[u] > depths[v]) {
				u = getAncestor(u, depths[u] - depths[v]);
			} else {
				v = getAncestor(v, depths[v] - depths[u]);
			}
		}

		if (u == v) {
			return u;
		}

		for (int j = cols - 1; j >= 0; j--) {
			if (parent[u][j] == -1) {
				continue;
			}

			if (parent[u][j] != parent[v][j]) {
				u = parent[u][j];
				v = parent[v][j];
			}
		}
		return parent[u][0];
	}

	private int getAncestor(int node, int k) {
		for (int j = 0; j < cols; j++) {
			if ((k & (1 << j)) != 0) {
				node = parent[node][j];
				if (node == -1) {
					return -1;
				}
			}
		}

		return node;
	}

	private void buildAncestor() {
		for (int j = 1; j < cols; j++) {
			for (int node = 0; node <= n; node++) {
				if (parent[node][j - 1] != -1) {
					parent[node][j] = parent[parent[node][j - 1]][j - 1];
				}
			}
		}
	}

	private void DFS(int source, int par, int depth) {
		parent[source][0] = par;
		depths[source] = depth;

		for (int dest : adj.get(source)) {
			if (par != dest) {
				DFS(dest, source, depth + 1);
			}
		}
	}

	public static void main(String[] args) {
		int[][] edges = { { 1, 2 }, { 1, 3 }, { 3, 4 }, { 3, 5 } };
		int[][] queries = { { 1, 4 }, { 3, 4 }, { 2, 5 } };

		Solution1 sol1 = new Solution1();
		int[] res = sol1.assignEdgeWeights(edges, queries);

		System.out.println(Arrays.toString(res));
	}
}