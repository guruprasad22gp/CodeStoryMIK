package Maximum_Score_After_Splitting_a_String;

public class Solution3 {
	public static void main(String[] args) {
		String s = "1111";
		Solution3 sol3 = new Solution3();
		
		System.out.println("Output: " + sol3.maxScore(s));
	}
	
    public int maxScore(String s) {
    	int one = 0;
    	int zero = 0;
    	int max = Integer.MIN_VALUE;
    	for(int i=0;i<s.length()-1;i++) {
    		if(s.charAt(i) == '0') {
    			zero++;
    		} else {
    			one++;
    		}
    		
    		max = Math.max(max, zero - one);
    	}
    	
    	return s.charAt(s.length()-1) == '1'? max + one + 1: max + one;
    }
}
