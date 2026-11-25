package Count_Elements_With_Maximum_Frequency;

public class Solution1 {
    public int maxFrequencyElements(int[] nums) {
    	int[] freq = new int[101];
    	int maxFreq = 0;
    	for(int ele: nums) {
    		freq[ele]++;
    		maxFreq = Math.max(maxFreq, freq[ele]);
    	}
    	
    	int count = 0;
    	for(int ele: freq) {
    		if(maxFreq == ele) {
    			count++;
    		}
    	}
    	
    	return count * maxFreq;
    }
    
    public static void main(String[] args) {
		int[] arr = {1,2,2,3,1,4};
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxFrequencyElements(arr));
	}
}
