package Maximum_Length_of_Pair_Chain;

import java.util.Arrays;

public class Solution3 {
    public int findLongestChain(int[][] pairs) {
    	int n = pairs.length;
    
    	Arrays.sort(pairs, (a, b) -> {
    		return Integer.compare(a[0], b[0]);
    	});
    	
    	int[] dp = new int[n+1];
    	Arrays.fill(dp, 1);
    	
    	int result = 1;
    	
    	for(int i=1;i<n;i++) {
    		for(int j=0;j<i;j++) {
    			if(pairs[i][0] > pairs[j][1]) {
    				dp[i] = Math.max(dp[i], dp[j] + 1);
        			result = Math.max(result, dp[i]);
    			}
    		}
    	}
    	
    	return result;
    }

    public static void main(String[] args) {
    	int[][] pairs = {{1,2},{7,8},{4,5}};
    	
    	Solution3 sol3 = new Solution3();
    	System.out.println("Output: " + sol3.findLongestChain(pairs));
	}
}
