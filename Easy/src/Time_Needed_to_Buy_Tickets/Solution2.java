package Time_Needed_to_Buy_Tickets;

public class Solution2 {
	public static void main(String[] args) {
		int[] tickets = {5,1,1,1};
		int k = 0;
		Solution2 sol2 = new Solution2();
		
		System.out.println("Output: " + sol2.timeRequiredToBuy(tickets, k));
	}
	
    public int timeRequiredToBuy(int[] tickets, int k) {
        int i = 0;
        int time = 0;
        
        int n = tickets.length;
        
        while(tickets[k] != 0) {        	
        	int index = i % n;
        	
        	if(tickets[index] != 0) {
            	time++;
        		tickets[index]--;
        	}
        	i++;
        }
        
        return time;
    }
}
