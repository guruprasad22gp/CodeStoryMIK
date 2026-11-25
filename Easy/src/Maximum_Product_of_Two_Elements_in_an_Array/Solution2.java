package Maximum_Product_of_Two_Elements_in_an_Array;

public class Solution2 {
    public int maxProduct(int[] nums) {
    		int first = 0;
    		int second = -1;
    		
    		for(int ele: nums) {
    			if(ele > first) {
    				second = first;
    				first = ele;
    			} else if(ele > second) {
    				second = ele;
    			}
    		}
    		
    		return (second - 1) * (first - 1);
    }
    
    public static void main(String[] args) {
		int[] arr = {3,2,5,2};
		
		Solution2 sol2 = new Solution2();
		System.out.println("output: " + sol2.maxProduct(arr));
	}
}
