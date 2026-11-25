package Largest_Local_Values_in_a_Matrix;

public class Solution1 {
    public int[][] largestLocal(int[][] grid) {
    	int n = grid.length;
    	
    	int[][] res = new int[n-2][n-2];
    	
    	for(int i=0;i<n-2;i++) {
    		for(int j=0;j<n-2;j++) {
    			res[i][j] = findMaxEle(grid, i, j);
    		}
    	}
    	
    	return res;
    }
    
    private int findMaxEle(int[][] mat, int row, int col) {
    	int max = Integer.MIN_VALUE;
    	for(int i=row;i<row+3;i++) {
    		for(int j=col;j<col+3;j++) {
    			max = Math.max(max, mat[i][j]);
    		}
    	}
    	
    	return max;
    }
    
	public static void main(String[] args) {
		int[][] grid = {
				{9,9,8,1},
				{5,6,2,6},
				{8,2,6,4},
				{6,2,2,2}
		};
		
		Solution1 sol1 = new Solution1();
		int[][] res = sol1.largestLocal(grid);
		
		for(int[] x: res) {
			for(int ele: x) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}
}
