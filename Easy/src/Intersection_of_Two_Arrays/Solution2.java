package Intersection_of_Two_Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int ele: nums1) {
        	set.add(ele);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int ele: nums2) {
        	if(set.contains(ele)) {
        		list.add(ele);
        		set.remove(ele);
        	}
        }
        
        int[] arr = new int[list.size()];
        int i=0;
        for(int ele: list) {
        	arr[i] = ele;
        	i++;
        }
        
        return arr;
    }
    
    public static void main(String[] args) {
    	int[] nums1 = {1,2,2,1,4,3,2,5,6,78,3};
    	int[] nums2 = {2,2,1,3,4,5};
    	
    	Solution2 sol2 = new Solution2();
    	
    	int[] res = sol2.intersection(nums1, nums2);
    	for(int ele: res) {
    		System.out.print(ele + " ");
    	}
	}
}
