package Maximum_Score_After_Splitting_a_String;

public class Solution1 {
	public static void main(String[] args) {
		String s = "1111";
		Solution1 sol1 = new Solution1();
		
		System.out.println("Output: " + sol1.maxScore(s));
	}
	
    public int maxScore(String s) {
    	int max = 0;
    	
    	for(int i=0;i<s.length()-1;i++) {
    		int zero = 0;
    		for(int j=0;j<=i;j++) {
    			if(s.charAt(j) == '0') {
    				zero++;
    			}
    		}
    		
    		int one = 0;
    		for(int j=i+1;j<s.length();j++) {
    			if(s.charAt(j) == '1') {
    				one++;
    			}
    		}
    		
    		max = Math.max(max, one+zero);
    	}
    	
    	return max;
    }
}
