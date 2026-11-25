package Redistribute_Characters_to_Make_All_Strings_Equal;

import java.util.HashMap;

public class Solution1 {
	public static void main(String[] args) {
		String words[] = {"ab","a"};
		
		Solution1 sol1 = new Solution1();
		
		System.out.println("Output: " + sol1.makeEqual(words));
	}
	
    public boolean makeEqual(String[] words) {
    	int n = words.length;
    	
    	HashMap<Character, Integer> map = new HashMap<>();
    	
    	for(String word: words) {
    		for(char ch: word.toCharArray()) {
    			map.put(ch, map.getOrDefault(ch, 0) + 1);
    		}
    	}
    	
    	for(int val: map.values()) {
    		if(val % n != 0) {
    			return false;
    		}
    	}
    	
    	return true; 
    }
}
