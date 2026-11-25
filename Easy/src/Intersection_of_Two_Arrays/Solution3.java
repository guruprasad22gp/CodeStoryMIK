package Intersection_of_Two_Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class Solution3 {
    public int[] intersection(int[] nums1, int[] nums2) {
    	Arrays.sort(nums1);
        
        HashSet<Integer> set = new HashSet<>();
        for(int ele: nums2) {
        	if(binarySearch(nums1, ele)) {
        		set.add(ele);
        	}
        }
        
        int[] arr = new int[set.size()];
        int i=0;
        for(int ele: set) {
        	arr[i] = ele;
        	i++;
        }
        
        return arr;
    }
    
    private boolean binarySearch(int[] arr, int key) {
    	int left = 0;
    	int right = arr.length-1;
    	
    	while(left <= right) {
    		int mid = left + (right - left)/2;
    		
    		if(key == arr[mid]) {
    			return true;
    		} else if(key > arr[mid]) {
    			left = mid + 1;
    		} else {
    			right = mid - 1;
    		}
    	}
    	
    	return false;
    }
    
    public static void main(String[] args) {
    	int[] nums1 = {1,2,2,1,4,3,2,5,6,78,3};
    	int[] nums2 = {2,2,1,3,4,5};
    	
    	Solution3 sol3 = new Solution3();
    	
    	int[] res = sol3.intersection(nums1, nums2);
    	for(int ele: res) {
    		System.out.print(ele + " ");
    	}
	}
}
