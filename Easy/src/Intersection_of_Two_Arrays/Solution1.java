package Intersection_of_Two_Arrays;

import java.util.HashSet;
import java.util.TreeSet;

public class Solution1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        HashSet<Integer> result = new HashSet<>();
        
        for(int ele: nums1) {
        	set.add(ele);
        }
        
        for(int ele: nums2) {
        	if(set.contains(ele)) {
        		result.add(ele);
        	}
        }
        
        int i =0 ;
        int[] arr = new int[result.size()];
        for(int ele: result) {
        	arr[i] = ele;
        	i++;
        }
        
        return arr;
    }
    
    public static void main(String[] args) {
    	int[] nums1 = {1,2,2,1,4,3,2,5,6,78,3};
    	int[] nums2 = {2,2, 1, 3,4,5};
    	
    	Solution1 sol1 = new Solution1();
    	
    	int[] res = sol1.intersection(nums1, nums2);
    	for(int ele: res) {
    		System.out.print(ele + " ");
    	}
	}
}
