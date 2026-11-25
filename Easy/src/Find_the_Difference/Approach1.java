package Find_the_Difference;

import java.util.HashMap;
import java.util.Map;

public class Approach1 {
	public char findTheDifference(String s, String t) {
	    HashMap<Character, Integer> map = new HashMap<>();
	    for(char ch: s.toCharArray()) {
	    	map.put(ch, map.getOrDefault(ch, 0) + 1);
	    }
	    
	    for(char ch: t.toCharArray()) {
	    	if(!map.containsKey(ch)) {
	    		return ch;
	    	}
	    	map.put(ch, map.getOrDefault(ch, 0) - 1);
	    }
	    
	    for(Map.Entry<Character, Integer> entry: map.entrySet()) {
	    	if(entry.getValue() < 0) {
	    		return entry.getKey();
	    	}
	    }
	    
	    return ' ';
	}
	
	public static void main(String[] args) {
		Approach1 m = new Approach1();
		String s = "abcdef";
		String t = "abcedfa";
		
		System.out.println("Output: " + m.findTheDifference(s, t));
	}
}
