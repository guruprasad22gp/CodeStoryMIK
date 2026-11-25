package N_th_Tribonacci_Number;

public class Solution4 {
    public int tribonacci(int n) {
        if(n == 0) {
            return  0;
        } else if(n == 1 || n == 2) {
            return 1;
        }
        
        int first = 0;
        int sec = 1;
        int third = 1;
        int result = third;
        for(int i=3;i<=n;i++) {
        	result = first + sec + third;
        	first = sec;
        	sec = third;
        	third = result;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
		int n = 4;
		
		Solution4 sol4 = new Solution4();
		
		System.out.println("Output: " + sol4.tribonacci(n));
	}
}
