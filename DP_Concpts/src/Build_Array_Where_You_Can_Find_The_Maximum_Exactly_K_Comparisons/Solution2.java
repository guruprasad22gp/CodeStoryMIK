package Build_Array_Where_You_Can_Find_The_Maximum_Exactly_K_Comparisons;

public class Solution2 {
	public static void main(String[] args) {
   	 int n = 2;
   	 int m = 4;
   	 int k = 1;
   	  
   	 Solution2 sol2 = new Solution2();
   	 System.out.println("Output: " + sol2.numOfArrays(n, m, k));
	}
	
    public int numOfArrays(int n, int m, int k) {
    	int idx = 0;
    	int searchCost = 0;
    	int maxSoFor = -1;
    	
    	return solve(idx, searchCost, maxSoFor, n, m, k);
    }
    
    private int solve(int idx, int searchCost, int maxSoFor, int n, int m, int k) {
    	if(idx >= n) {
    		if(searchCost == k) {
    			return 1;
    		} else {
    			return 0;
    		}
    	}
    	
    	int result = 0;
    	
    	for(int i=1;i<=m;i++) {
    		if(i > maxSoFor) {
    			result += solve(idx+1, searchCost+1, i, n, m, k);
    		} else {
    			result += solve(idx+1, searchCost, maxSoFor, n, m, k);
    		}
    	}
    	
    	return result;
    }
}
