package Maximum_Product_Difference_Between_Two_Pairs;

public class Solution1 {
    public int maxProductDifference(int[] nums) {
        int secondLargest = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;
        
        for(int ele: nums) {
        	if(largest < ele) {
        		secondLargest = largest;
        		largest = ele;
        	} else if(secondLargest < ele) {
        		secondLargest = ele;
        	}
        	
        	if(smallest > ele) {
        		secondSmallest = smallest;
        		smallest = ele;
        	} else if(secondLargest > ele) {
        		secondSmallest = ele;
        	}
        }
        
        return (largest * secondLargest) - (smallest * secondSmallest);
    }
    
    public static void main(String[] args) {
    	int[] nums = {5,6,2,7,4};
    	
    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.maxProductDifference(nums));

	}
}
