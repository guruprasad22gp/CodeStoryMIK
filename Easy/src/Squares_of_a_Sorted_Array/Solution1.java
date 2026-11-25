package Squares_of_a_Sorted_Array;

import java.util.Arrays;

public class Solution1 {
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++) {
        	nums[i] = nums[i] * nums[i];
        }
        
        Arrays.sort(nums);
        
        return nums;
    }
    
    public static void main(String[] args) {
		int[] arr = {-4, -1, 0, 3, 10};
		
		Solution1 sol1 = new Solution1();
		arr = sol1.sortedSquares(arr);
		
		for(int ele: arr) {
			System.out.print(ele + " ");
		}
	}
}
