package Time_Needed_to_Buy_Tickets;

public class Solution3 {
	public static void main(String[] args) {
		int[] tickets = {2,3,2,4,1};
		int k = 2;
		Solution3 sol3 = new Solution3();
		
		System.out.println("Output: " + sol3.timeRequiredToBuy(tickets, k));
	}
	
    public int timeRequiredToBuy(int[] tickets, int k) {
       int total = 0;
       
       for(int i=0;i<=k;i++) {
    	   total += Math.min(tickets[i], tickets[k]);
       }
       
       for(int i=k+1;i<tickets.length;i++) {
    	   total += Math.min(tickets[i], tickets[k]-1);
       }
       
       return total;
        
    }
}
