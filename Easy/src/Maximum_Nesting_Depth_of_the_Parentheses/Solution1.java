package Maximum_Nesting_Depth_of_the_Parentheses;

import java.util.Stack;

public class Solution1 {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int max = 0;
        for(char ch: s.toCharArray()) {
        	if(ch == '(') {
        		stack.add('(');
        	} else if(ch == ')') {
        		max = Math.max(stack.size(), max);
        		stack.pop();
        	}
        }
        
        return max;
    }
    
    public static void main(String[] args) {
		String s = "(1)+((2))+(((3)))";
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxDepth(s));
	}
}
