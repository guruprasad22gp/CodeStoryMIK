package Largest_Positive_Integer_That_Exists_With_Its_Negative;

public class Solution4 {
    public int findMaxK(int[] nums) {
    	int[] index = new int[2002];
    	int maxEle = -1;
    	for(int ele: nums) {
    		if(ele < 0) {
    			index[ele + 1000] = 1;
    			if(index[-ele + 1000] == 1) {
    				maxEle = Math.max(maxEle, -ele);
    			}
    		} else {
    			index[ele+1000] = 1;
    			if(index[-ele+1000] == 1) {
    				maxEle = Math.max(maxEle, ele);
    			}
    		}
    	}
    	
    	return maxEle;
    }
    
    public static void main(String[] args) {
		int[] nums = {-1,10,6,7,-7,1};
		
		Solution4 sol4 = new Solution4();
		System.out.println("Output: " + sol4.findMaxK(nums));
	}
}
