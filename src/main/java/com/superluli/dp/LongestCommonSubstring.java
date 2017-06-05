package com.superluli.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		System.err.println(LCS("AXXXABC", "ABC"));
		System.err.println(LCSDP("AXXXABCABC", "XABC"));
	}

	public static int LCS(String s1, String s2) {

		return LCS(s1, s2, 0, 0, false);
	}

	public static int LCS(String s1, String s2, int from1, int from2,
			boolean started) {

		if (from1 == s1.length() || from2 == s2.length())
			return 0;
		int bothNext = 0, s1Next = 0, s2Next = 0;
		if (s1.charAt(from1) == s2.charAt(from2))
			bothNext = 1 + LCS(s1, s2, from1 + 1, from2 + 1, true);
		if (!started) {
			s1Next = LCS(s1, s2, from1 + 1, from2, false);
			s2Next = LCS(s1, s2, from1, from2 + 1, false);
		}
		return Math.max(Math.max(s1Next, s2Next), bothNext);
	}

	/*
	 * First find the longest common suffix for all pairs of prefixes of these 2 
	 * strings. The maximal of these longest common suffixes of possible
	 * prefixes must be the longest common substrings of S and T
	 */
	public static List<String> LCSDP(String s1, String s2) {

		int maxLen = 0;

		List<String> list = new ArrayList<String>();
		String[][] dp = new String[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], "");
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
					if (dp[i][j].length() == maxLen) {
						list.add(dp[i][j]);
					}
					if (dp[i][j].length() > maxLen) {
						list.clear();
						list.add(dp[i][j]);
						maxLen = dp[i][j].length();
					}
				}
			}
		}
		return list;
	}
}
