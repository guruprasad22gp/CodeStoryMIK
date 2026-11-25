package Special_Positions_in_a_Binary_Matrix;

public class Solution1 {
	public static void main(String[] args) {
		Solution1 sol1 = new Solution1();
		int[][] mat = {
				{1,0,0},
				{0,0,1},
				{1,0,0}
		};
		
		System.out.println("Output: " + sol1.numSpecial(mat));
	}
	
    public int numSpecial(int[][] mat) {
        int count = 0;
        int m = mat.length;
        int n = mat[0].length;
        
        for(int row = 0; row < m; row++) {
        		for(int col=0;col < n; col++) {
        			if(mat[row][col] == 1) {
        				if(checkRow(mat, row) && checkCol(mat, col)) {
        					count++;
        				}
        			}
        		}
        }
        
        return count;
    }
    
    private boolean checkRow(int[][] mat, int i) {
    		int count = 0;
    		for(int j=0;j<mat.length;j++) {
    			if(mat[i][j] == 1) {
    				count++;
    			}
    			
    			if(count == 2) {
    				return false;
    			}
    		}
    		return true;
    }
    
    private boolean checkCol(int[][] mat, int i) {
		int count = 0;
		for(int j=0;j<mat.length;j++) {
			if(mat[j][i] == 1) {
				count++;
			}
			
			if(count == 2) {
				return false;
			}
		}
		return true;
    }
}
