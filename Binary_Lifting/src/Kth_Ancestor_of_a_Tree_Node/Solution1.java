package Kth_Ancestor_of_a_Tree_Node;

import java.util.Arrays;

class TreeAncestor {
    int[][] ancestor;

    public TreeAncestor(int n, int[] parent) {
        int cols =(int)(Math.log(n) / Math.log(2) + 1e-11) + 1;
        ancestor = new int[n][cols];
        for (int[] x : ancestor) {
            Arrays.fill(x, -1);
        }

        for (int i = 0; i < n; i++) {
            ancestor[i][0] = parent[i];
        }

        for (int j = 1; j < ancestor[0].length; j++) {
            for (int node = 0; node < n; node++) {
                if (ancestor[node][j - 1] != -1) {
                    ancestor[node][j] = ancestor[ancestor[node][j - 1]][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < ancestor[0].length; j++) {
            if ((k & (1 << j)) != 0) {
                node = ancestor[node][j];
                if (node == -1) {
                    return -1;
                }
            }
        }

        return node;
    }
}

public class Solution1 {
	public static void main(String[] args) {
		int n = 7;
		int[] parent = {-1, 0, 0, 1, 1, 2, 2};
		
		TreeAncestor ta = new TreeAncestor(n, parent);
		System.out.println("Output: " + ta.getKthAncestor(3, 1));
		System.out.println("Output: " + ta.getKthAncestor(5, 2));
		System.out.println("Output: " + ta.getKthAncestor(6, 3));
	}
}
