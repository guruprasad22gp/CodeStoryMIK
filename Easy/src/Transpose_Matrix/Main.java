package Transpose_Matrix;

public class Main {
	public static void main(String[] args) {
		int[][] matrix = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
			};
		Main m = new Main();
		matrix = m.transpose(matrix);
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
				
	}
	
    public int[][] transpose(int[][] matrix) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int[][] result = new int[n][m];
    	
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(i == j) {
    				result[i][j] = matrix[i][j];
    				continue;
    			}
    			result[j][i] = matrix[i][j];
    		}
    	}
    	
    	return result;
    }
}
