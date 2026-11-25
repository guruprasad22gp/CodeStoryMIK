package Intersection_of_Two_Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class Solution4 {
    public int[] intersection(int[] nums1, int[] nums2) {
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	
    	HashSet<Integer> set = new HashSet<>();
    	
    	int i = 0;
    	int j = 0;
    	
    	while(i < nums1.length && j < nums2.length) {
    		if(nums1[i] == nums2[j]) {
    			set.add(nums1[i]);
    			i++;
    			j++;
    		} else if(nums1[i] < nums2[j]) {
    			i++;
    		} else {
    			j++;
    		}
    	}
    	
    	int[] result = new int[set.size()];
    	i = 0;
    	System.out.println(set);
    	for(int ele: set) {
    		result[i] = ele;
    		i++;
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
    	int[] nums1 = {1,2,2,1,4,3,2,5,6,78,3};
    	int[] nums2 = {2,2,3, 2,1,3,4,5};
    	
    	Solution4 sol4 = new Solution4();
    	
    	int[] res = sol4.intersection(nums1, nums2);
    	for(int ele: res) {
    		System.out.print(ele + " ");
    	}
	}
}
