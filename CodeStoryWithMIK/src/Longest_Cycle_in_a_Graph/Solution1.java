package Longest_Cycle_in_a_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
	int result = -1;

	void DFS(int u, List<List<Integer>> adj, boolean[] visited, boolean[] recursion, int[] count) {
		visited[u] = true;
		recursion[u] = true;

		for (int v : adj.get(u)) {
			if (!visited[v]) {
				count[v] = count[u] + 1;
				DFS(v, adj, visited, recursion, count);
			} else if (recursion[v]) {
				result = Math.max(result, count[u] - count[v] + 1);
			}
		}

		recursion[u] = false;
	}

	public int longestCycle(int[] edges) {
		int n = edges.length;
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			int u = i;
			int v = edges[i];
			if (v == -1) {
				continue;
			}
			adj.get(u).add(v);
		}

		boolean[] visited = new boolean[n];
		boolean[] recursion = new boolean[n];
		int[] count = new int[n];
		Arrays.fill(count, 1);

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				DFS(i, adj, visited, recursion, count);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] edges = { 3, 3, 4, 2, 3 };
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.longestCycle(edges));
	}
}