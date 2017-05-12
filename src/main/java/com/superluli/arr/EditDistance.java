package com.superluli.arr;

/*
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 */
public class EditDistance {

	public static void main(String[] args) {

		// System.err.println(editDistance("", ""));
		// System.err.println(editDistance("a", ""));
		// System.err.println(editDistance("", "a"));
		System.err.println(editDistance("a", "ab"));
		System.err.println(editDistance("abc", "abd"));
		System.err.println(editDistance("abcdef", "bcdefg"));
		System.err.println(editDistance("abcdef", "bcdefx"));
		System.err.println(editDistance("abcdef", "bcxefg"));
		System.err.println(editDistance("bxef", "bcxefg"));
	}
	
	public static int editDistance(String s1, String s2) {

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = s1.length(); i >= 0; i--) {
			dp[i][s2.length()] = s1.length() - i;
		}

		for (int j = s2.length(); j >= 0; j--) {
			dp[s1.length()][j] = s2.length() - j;
		}

		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				char c1 = s1.charAt(i), c2 = s2.charAt(j);
				if (c1 == c2)
					dp[i][j] = dp[i + 1][j + 1];
				else {
					int add = dp[i][j + 1];
					int delete = dp[i + 1][j];
					int replace = dp[i + 1][j + 1];
					dp[i][j] = 1 + Math.min(Math.min(add, delete), replace);
				}
			}
		}
		return dp[0][0];
	}
}
