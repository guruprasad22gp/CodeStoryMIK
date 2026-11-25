package Count_of_Matches_in_Tournament;

public class Approach1 {
	public static void main(String[] args) {
		int n = 7;
		Main m = new Main();
		System.out.println("Output: " + m.numberOfMatches(n));
	}
	
    public int numberOfMatches(int n) {
    	return n-1;
    }
}
