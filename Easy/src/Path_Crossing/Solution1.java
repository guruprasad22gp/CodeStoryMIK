package Path_Crossing;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
	public static void main(String[] args) {
		String s = "NES";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.isPathCrossing(s));
	}
	
    public boolean isPathCrossing(String path) {
        int y = 0;
        int x = 0;
        Set<String> set = new HashSet<>();
        set.add(x + "," + y);
        for(char ch: path.toCharArray()) {
        	if(ch == 'N') {
        		y  ++;
        	} else if(ch == 'S') {
        		y--;
        	} else if(ch == 'E') {
        		x++;
        	} else {
        		x--;
        	}
        	
        	String ans = x + "," + y;
        	
        	if(set.contains(ans)) {
        		return true;
        	}
        	set.add(ans);
        }
        
        return false;
    }
}
