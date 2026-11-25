package Maximum_Score_After_Splitting_a_String;

public class Solution2 {
	public static void main(String[] args) {
		String s = "011101";
		Solution2 sol2 = new Solution2();
		
		System.out.println("Output: " + sol2.maxScore(s));
	}
	
    public int maxScore(String s) {
    	int oneCount = 0;
    	for(char ch: s.toCharArray()) {
    		if(ch == '1') {
    			oneCount++;
    		}
    	}
    	
    	int one = 0;
    	int zero = 0;
    	int max = 0;
    	for(int i=0;i<s.length()-1;i++) {
    		if(s.charAt(i) == '0') {
    			zero++;
    		} else {
    			one++;
    		}
    		
    		max = Math.max(max, zero + (oneCount - one));
    	}
    	
    	return max;
    }
}
