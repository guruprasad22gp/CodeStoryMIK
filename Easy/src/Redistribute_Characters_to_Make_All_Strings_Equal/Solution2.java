package Redistribute_Characters_to_Make_All_Strings_Equal;

public class Solution2 {
	public static void main(String[] args) {
		String words[] = {"ab","ab", "abbbb"};
		
		Solution2 sol2 = new Solution2();
		
		System.out.println("Output: " + sol2.makeEqual(words));
	}
	
    public boolean makeEqual(String[] words) {
    	int[] count = new int[26];
    	
    	for(String word: words) {
    		for(char ch: word.toCharArray()) {
    			count[ch - 'a']++;
    		}
    	}
    	
    	for(int ele: count) {
    		if(ele % words.length != 0) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}
