package Divide_Array_Into_Arrays_With_Max_Difference;

import java.util.Arrays;

public class Solution1 {
	public static void main(String[] args) {
		int[] nums = {2,4,2,2,5,2};
		int k = 2;
		
		Solution1 sol1 = new Solution1();
		int[][] result = sol1.divideArray(nums, k);
		
		System.out.println("Output: ");
		for(int[] x: result) {
			for(int ele: x) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}
	
    public int[][] divideArray(int[] nums, int k) {
    	Arrays.sort(nums);
//    	2,2,2,2,4,5
    	int  i = 0;
    	int[][] result = new int[nums.length/3][3];
    	int j = 0;
    	while(i < nums.length-2) {
//    		System.out.print(nums[i] + " " + nums[i+1] + " " + nums[i+2]);
    		if(nums[i+2] - nums[i] <= k ) {
    			result[j][0] = nums[i];
    			result[j][1] = nums[i+1];
    			result[j][2] = nums[i+2];
    			j++;
    			i+=3;
    		} else {
    			return new int[][] {};
    		}
    	}
    	
    	return result;
    }
}
