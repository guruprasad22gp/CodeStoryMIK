package Maximize_Active_Section_with_Trade_I;

import java.util.LinkedList;

/*
 *  ex: s = "1000100"
 *  Augmented to = "110001001"
 *  				110000001 // 1 surrounded by 0 that why we converted into 0 
 *  				111111111
 *  remove 2 1's that we added extra to both sides left and right;
 *  s = "111111"
 *  output: = 7;
 *  	
 *  
 *  
 * */
public class Solution1 {
	public int maxActiveSectionsAfterTrade(String s) {
		int activeCount = 0;
		LinkedList<Integer> inActiveCount = new LinkedList<>();

		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) == '0') {
				int start = i;
				while (i < s.length() && s.charAt(i) == '0') {
					i++;
				}
				inActiveCount.add(i - start);
			} else {
				activeCount++;
				i++;
			}
		}

		System.out.println(inActiveCount);

		int maxSum = 0;
		for (int j = 1; j < inActiveCount.size(); j++) {
			maxSum = Math.max(maxSum, inActiveCount.get(j - 1) + inActiveCount.get(j));
		}

		return maxSum + activeCount;
	}

	public static void main(String[] args) {
		String s = "01";
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.maxActiveSectionsAfterTrade(s));
	}
}
