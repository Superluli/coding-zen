package com.superluli.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		System.err.println(LCS("ABCDEFXG", "ACXDEFXXXG"));
		System.err.println(LCSDP("ABABCXXD", "BABACD"));
	}

	public static int LCS(String s1, String s2) {

		return LCS(s1, s2, 0, 0);
	}

	public static int LCS(String s1, String s2, int from1, int from2) {

		if (from1 == s1.length() || from2 == s2.length())
			return 0;
		if (s1.charAt(from1) == s2.charAt(from2))
			return 1 + LCS(s1, s2, from1 + 1, from2 + 1);
		else
			return Math.max(LCS(s1, s2, from1 + 1, from2),
					LCS(s1, s2, from1, from2 + 1));
	}

	public static List<String> LCSDP(String s1, String s2) {
		
		int maxLen = 0;
		
		List<String> list = new ArrayList<String>();
		String[][] dp = new String[s1.length() + 1][s2.length() + 1];
		for(int i = 0; i < dp.length; i++){
			Arrays.fill(dp[i], "");
		}
		
		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)){
					dp[i][j] = s1.charAt(i) + dp[i + 1][j + 1];
					if(dp[i][j].length() == maxLen){
						list.add(dp[i][j]);
					}
					if(dp[i][j].length() > maxLen){
						list.clear();
						list.add(dp[i][j]);
						maxLen = dp[i][j].length();
					}
				}
				else{
					String sRight = dp[i + 1][j];
					String sDown = dp[i][j+1];
					dp[i][j] = sRight.length() >= sDown.length() ? sRight : sDown;
				}	
			}
		}
		return list;
	}
}
