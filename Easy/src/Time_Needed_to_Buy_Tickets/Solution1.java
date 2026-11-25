package Time_Needed_to_Buy_Tickets;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
	public static void main(String[] args) {
		int[] tickets = {2,3,2};
		int k = 2;
		Solution1 sol1 = new Solution1();
		
		System.out.println("Output: " + sol1.timeRequiredToBuy(tickets, k));
	}
	
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<tickets.length;i++) {
        	queue.add(i);
        }
        
        int second = 0;
        
        while(!queue.isEmpty()) {
        	int index = queue.poll();
        	
        	second++;
        	
        	if(tickets[index] != 0) {
        		tickets[index]--; 
        		
        		if(tickets[index] != 0) {
        			queue.add(index);
        		}
        	}
        	
        	if(tickets[k] == 0) {
        		return second;
        	}
        }
        
        return -1;
        
    }
}
