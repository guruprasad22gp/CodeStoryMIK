package Shortest_Common_Supersequence_Printing;

public class Solution1 {
    
	public String shortestCommonSupersequence(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i=m;i>=0;i--) {
			for(int j=n;j>=0;j--) {
				if(i == m) {
					dp[i][j] = n- j;
				} else if(j == n) {
					dp[i][j] = m - i;
				} else if(str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = 1 + dp[i+1][j+1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		
		for(int[] x: dp) {
			for(int ele: x) {
				System.out.print( ele + " ");
			}
			System.out.println();
		}
		
		StringBuilder result = new StringBuilder();
		int i = 0;
		int j = 0;
		
		while(i < m &&  j < n) {
			if(str1.charAt(i) == str2.charAt(j)) {
				result.append(str1.charAt(i));
				i++;
				j++;
			} else {
				if(dp[i+1][j] > dp[i][j+1]) {
					result.append(str2.charAt(j));
					j++;
				} else {
					result.append(str1.charAt(i));
					i++;
				}
			}
		}
		
		while(i < m) {
			result.append(str1.charAt(i));
			i++;
		}
		
		while(j < n) {
			result.append(str2.charAt(j));
			j++;
		}
		
		return result.toString();
    }
	
	public static void main(String[] args) {
		String s1 = "aaaaaaaa";
		String s2 = "aaaaaaaa";
		
		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.shortestCommonSupersequence(s1, s2));
	}

}
