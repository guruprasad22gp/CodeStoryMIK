package Special_Positions_in_a_Binary_Matrix;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol2 = new Solution2();
		int[][] mat = {
				{1,0,0},
				{0,0,1},
				{0,1,0}
		};
		
		System.out.println("Output: " + sol2.numSpecial(mat));
	}
	
    public int numSpecial(int[][] mat) {
    		int m = mat.length;
    		int n = mat[0].length;
    		
    		int rowCount[] = new int[m];
    		int colCount[] = new int[n];
    		
    		for(int i=0;i<m;i++) {
    			for(int j=0;j<n;j++) {
    				if(mat[i][j] == 1) {
    					rowCount[i] += 1;
    					colCount[j] += 1;
    				}
    			}
    		}
    		
    		int count = 0;
    		for(int i=0;i<m;i++) {
    			for(int j=0;j<n;j++) {
    				if(mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
    					count++;
    				}
    			}
    		}
    		
    		return count;
    }
}
