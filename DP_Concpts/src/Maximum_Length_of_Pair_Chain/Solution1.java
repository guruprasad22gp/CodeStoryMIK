package Maximum_Length_of_Pair_Chain;

import java.util.Arrays;

public class Solution1 {
    public int findLongestChain(int[][] pairs) {
    	Arrays.sort(pairs, (a, b) -> {
    		return Integer.compare(a[0], b[0]);
    	});
    	
    	int i = 0;
    	int prevIdx = -1;
    	
    	return solve(i, prevIdx, pairs);
    }
    
    private int solve(int i, int prevIdx, int[][] pairs) {
    	if(i >= pairs.length) {
    		return 0;
    	}
    	
    	int skip = solve(i + 1, prevIdx, pairs);
    	
    	int take = 0;
    	
    	if(prevIdx == -1 || pairs[prevIdx][1] < pairs[i][0]) {
    		take = 1 + solve(i+1, i, pairs);
    	}
    	
    	return Math.max(take, skip);
    }

    public static void main(String[] args) {
    	int[][] pairs = {{1,2},{7,8},{4,5}};
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.findLongestChain(pairs));
	}
}
