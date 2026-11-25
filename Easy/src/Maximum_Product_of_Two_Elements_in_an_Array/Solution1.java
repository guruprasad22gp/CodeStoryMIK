package Maximum_Product_of_Two_Elements_in_an_Array;

public class Solution1 {
    public int maxProduct(int[] nums) {
    		int currentMax = nums[0];
    		int result = 0;
    		
    		for(int i=1;i<nums.length;i++) {
    			result = Math.max(result, (currentMax - 1) * (nums[i] - 1));
    			
    			if(currentMax < nums[i]) {
    				currentMax = nums[i];
    			}
    		}
    		
    		return result;
    }

    public static void main(String[] args) {
		int[] arr = {3,4,5,2};
		
		Solution1 s1 = new Solution1();
		System.out.println("output: " + s1.maxProduct(arr));
	}
}
