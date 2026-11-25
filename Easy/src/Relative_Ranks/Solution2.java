package Relative_Ranks;

import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
	int val;
	int index;
	
	Pair(int val, int index) {
		this.val = val;
		this.index = index;
	}

	@Override
	public int compareTo(Pair o) {
		return o.val - this.val;
	}
}

public class Solution2 {
	public String[] findRelativeRanks(int[] score) {
		PriorityQueue<Pair> queue = new PriorityQueue<>();
		for(int i=0;i<score.length;i++) {
			queue.add(new Pair(score[i], i));
		}
		
		String[] result = new String[score.length];
		int rank = 0;
		
		while(!queue.isEmpty()) {
			Pair t = queue.poll();
			int index = t.index;
			if(rank == 0) {
				result[index] = "Gold Medal";
			} else if(rank == 1) {
				result[index] = "Silver Medal";
			} else if(rank == 2) {
				result[index] = "Bronze Medal";
			} else {
				result[index] = String.valueOf(rank+1);
			}
			
			rank++;
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		int score[] = { 10,3,8,9,4}; 

		Solution2 sol3 = new Solution2();
		String[] res = sol3.findRelativeRanks(score);
		for(String s: res) {
			System.out.print(s + " ");
		}
	}
}
