package First_Unique_Character_in_a_String;

public class Solution1 {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for(char ch: s.toCharArray()) {
        	arr[ch-'a']++;
        }
        for(int i=0;i<s.length();i++) {
        	if(arr[s.charAt(i)-'a'] == 1) {
        		return i;
        	}
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
		String s = "aabb";
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.firstUniqChar(s));
	}
}
