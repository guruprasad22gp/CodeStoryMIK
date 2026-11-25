package Count_Elements_With_Maximum_Frequency;

public class Solution2 {
    public int maxFrequencyElements(int[] nums) {
    	int[] freq = new int[101];
    	int maxFreq = 0;
    	int total = 0;
    	
    	for(int ele: nums) {
    		freq[ele]++;
    		if(freq[ele] > maxFreq) {
    			maxFreq = freq[ele];
    			total = maxFreq;
    		} else if(freq[ele] == maxFreq) {
    			total += maxFreq;
    		}
    	}
    	
    	return total;
    }
    
    public static void main(String[] args) {
		int[] arr = {1,2,2,3,1,4};
		
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.maxFrequencyElements(arr));
	}
}
