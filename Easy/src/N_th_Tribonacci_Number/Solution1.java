package N_th_Tribonacci_Number;

public class Solution1 {
    public int tribonacci(int n) {
        return find(n);
    }
    
    private int find(int n) {
    	if(n <= 1) {
    		return n;
    	} else if(n == 2) {
    		return 1;
    	}
    	
    	return find(n-1) + find(n-2) + find(n-3);
    }
    
    public static void main(String[] args) {
		int n = 4;
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.tribonacci(n));
	}
}
