 package Count_of_Matches_in_Tournament;

public class Main {
    public int numberOfMatches(int n) {
        int matches = 0;
        
        while(n > 1) {
        	if(n % 2 != 0) {
        		n = (n-1)/2;
        		matches += n;
        		n += 1;
        	} else {
        		n = n/2;
        		matches += n;
        	}
        }
        
        
        return matches;
    }
    
    public static void main(String[] args) {
		int n = 7;
		Main m = new Main();
		System.out.println("Output: " + m.numberOfMatches(n));
	}

}
