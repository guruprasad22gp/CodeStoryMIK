package Maximum_Balanced_Subsequence_Sum;

import java.util.TreeMap;

public class Solution4 {
	public static void main(String[] args) {
		int[] nums = {-2, -1};
		
		Solution4 sol4 = new Solution4();
		System.out.println("Output: " + sol4.maxBalancedSubsequenceSum(nums));
	}

	public long maxBalancedSubsequenceSum(int[] nums) {
		int n = nums.length;
		int[] arr = new int[n];
		for(int i=0;i<n;i++)  {
			arr[i] = nums[i] - i;
		}
		
		long result = Long.MIN_VALUE;
		TreeMap<Integer, Long> map = new TreeMap<>();
		
		for(int i=0;i<n;i++) {
			if(nums[i] <= 0) {
				result = Math.max(result, nums[i]);
			} else {
				long temp = nums[i];
				
				if(map.floorKey(arr[i]) != null) {
					temp += map.get(map.floorKey(arr[i]));
				}
				
				while(map.ceilingKey(arr[i]) != null && map.get(map.ceilingKey(arr[i])) < temp) {
					map.remove(map.ceilingKey(arr[i]));
				}
				
				if(map.floorKey(arr[i]) == null || map.get(map.floorKey(arr[i])) < temp) {
					map.put(nums[i], temp);
				}
				
				result = Math.max(result, temp);
			}
		}
		
		return result;
	}
}
