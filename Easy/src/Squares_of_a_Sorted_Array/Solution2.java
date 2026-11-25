package Squares_of_a_Sorted_Array;

public class Solution2 {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int res[] = new int[nums.length];
        int k = nums.length-1;
        while(i <= j) {
        	if(nums[j] * nums[j] >= nums[i] * nums[i]) {
        		res[k] = nums[j] * nums[j];
        		j--;
        	} else {
        		res[k] = nums[i] * nums[i];
        		i++;
        	}
        	k--;
        }
        
        return res;
    }
//    -4, -1, 0, 3, 10
    public static void main(String[] args) {
		int[] arr = {-4, -1, 0, 3, 10};
		
		Solution2 sol2 = new Solution2();
		arr = sol2.sortedSquares(arr);
		
		for(int ele: arr) {
			System.out.print(ele + " ");
		}
	}
}
