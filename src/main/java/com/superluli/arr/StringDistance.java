package com.superluli.arr;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character b) Delete a character c) Replace a character
 * 
 * @author Lu
 *
 */
public class StringDistance {
	
	public static void main(String[] args) {

		Random r = new Random();

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		for (int i = 0; i < 5500; i++) {
			sb1.append((char)(33 + r.nextInt(92)));
			sb2.append((char)(33 + r.nextInt(92)));
		}

		String s1 = sb1.toString();
		String s2 = sb2.toString();

		System.err.println(s1);
		System.err.println(s2);
		
		long t1 = System.currentTimeMillis();

		System.err.println(new StringDistance().minDistance(s1, s2));

		long t2 = System.currentTimeMillis();

		System.err.println(new StringDistance().minDistanceDP(s1, s2));

		long t3 = System.currentTimeMillis();

		System.err.println(t2 - t1);
		System.err.println(t3 - t2);
	}

	public int minDistance(String word1, String word2) {

		int[][] cache = new int[word1.length()][word2.length()];

		for (int[] row : cache) {
			Arrays.fill(row, -1);
		}

		return minDistanceHelper(word1, word2, 0, 0, cache);
	}

	public int minDistanceHelper(String word1, String word2, int i, int j,
			int[][] cache) {

		if (i == word1.length()) {
			return word2.length() - j;
		}

		if (j == word2.length()) {
			return word1.length() - i;
		}

		if (cache[i][j] != -1) {
			return cache[i][j];
		}

		int c1 = word1.charAt(i);
		int c2 = word2.charAt(j);
		int result = 0;

		if (c1 == c2) {
			result = minDistanceHelper(word1, word2, i + 1, j + 1, cache);
		} else {
			int replace = 1 + minDistanceHelper(word1, word2, i + 1, j + 1,
					cache);
			int add = 1 + minDistanceHelper(word1, word2, i, j + 1, cache);
			int remove = 1 + minDistanceHelper(word1, word2, i + 1, j, cache);
			result = Math.min(Math.min(replace, add), remove);
		}
		cache[i][j] = result;
		return result;
	}

	public int minDistanceDP(String word1, String word2) {

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];

		for (int j = 0; j < dp[0].length; j++) {
			dp[word1.length()][j] = word2.length() - j;
		}

		for (int i = 0; i < dp.length; i++) {
			dp[i][word2.length()] = word1.length() - i;
		}

		for (int i = word1.length() - 1; i >= 0; i--) {
			for (int j = word2.length() - 1; j >= 0; j--) {
				if (word1.charAt(i) == word2.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1];
				} else {
					dp[i][j] = 1 + Math.min(
							Math.min(dp[i + 1][j], dp[i][j + 1]),
							dp[i + 1][j + 1]);
				}
			}
		}
		return dp[0][0];
	}
}
