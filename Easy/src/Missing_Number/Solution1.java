package Missing_Number;

public class Solution1 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean zero = false;
        int sum = n * (n + 1)/2;
        for(int ele: nums) {
        	sum -= ele;
        	
        	if(ele == 0) {
        		zero = true;
        	}
        }
        
        return zero? sum: 0;
    }

    public static void main(String[] args) {
		int[] nums = {3, 2, 1};
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.missingNumber(nums));
	}
}
