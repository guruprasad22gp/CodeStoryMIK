package Minimum_Common_Value;

public class Solution1 {
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,6};
		int[] nums2 = {4,5,6};
		Solution1 sol1 = new Solution1();
		
		System.out.println("Output: " + sol1.getCommon(nums1, nums2));
	}
	
    public int getCommon(int[] nums1, int[] nums2) {
    	int i = 0;
    	int j = 0;
    	int m = nums1.length;
    	int n = nums2.length;
    	
    	while(i < m && j < n) {
    		if(nums1[i] == nums2[j]) {
    			return nums1[i];
    		} else if(nums1[i] < nums2[j]) {
    			i++;
    		} else {
    			j++;
    		}
    	}
    	
    	return -1;
    }
}
