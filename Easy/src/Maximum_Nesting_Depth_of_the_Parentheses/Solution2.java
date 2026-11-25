package Maximum_Nesting_Depth_of_the_Parentheses;

public class Solution2 {
    public int maxDepth(String s) {
    	int current = 0;
        int max = 0;
        for(char ch: s.toCharArray()) {
        	if(ch == '(') {
        		current++;
        	} else if(ch == ')') {
        		max = Math.max(current, max);
        		current--;
        	}
        }
        
        return max;
    }
    
    public static void main(String[] args) {
		String s = "(1)+((2))+(((3)))";
		
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.maxDepth(s));
	}
}
