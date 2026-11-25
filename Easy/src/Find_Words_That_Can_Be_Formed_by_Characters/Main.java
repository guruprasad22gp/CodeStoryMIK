package Find_Words_That_Can_Be_Formed_by_Characters;

public class Main {
	public int countCharacters(String[] words, String chars) {
        int[] charsCount = new int[26];
        for(char ch: chars.toCharArray()) {
        	charsCount[ch - 'a']++;
        }
        
        int result = 0;
        
        for(String word: words) {
        	int[] wordCount = new int[26];
        	
        	for(char ch: word.toCharArray()) {
        		wordCount[ch - 'a']++;
        	}
        	
            boolean okay = true;
        	for(int i=0;i<26;i++) {
        		if(wordCount[i] > charsCount[i]) {
        			okay = false;
        			break;
        		}
        	}
        	
        	if(okay) {
        		result += word.length();
        	}
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		String[] arr = {"cat","bt","hat","tree"};
		String chars = "atach";
		
		Main m = new Main();
		
		System.out.println("Output: " + m.countCharacters(arr, chars));
	}
}
