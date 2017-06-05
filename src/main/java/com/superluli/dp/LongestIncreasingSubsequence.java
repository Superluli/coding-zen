package com.superluli.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

		System.err.println(lis(new int[] { 0, 8, 12, 2, 6, 14, 9, 13, 15 }));
	}

	
	/*
	 * DP : 
	 */
	public static List<Integer> lis(int[] arr) {

		List<Integer>[] dp = new ArrayList[arr.length];
		dp[dp.length - 1] = new ArrayList<Integer>();
		dp[dp.length - 1].add((arr[arr.length - 1]));
		int totalMaxLen = 0;
		List<Integer> lis = null;

		for (int i = dp.length - 1; i >= 0; i--) {

			int maxLen = 0;
			dp[i] = new ArrayList<Integer>();
			dp[i].add(arr[i]);
			for (int j = i + 1; j < dp.length; j++) {
				if (arr[i] <= arr[j] && dp[j].size() > maxLen) {
					maxLen = dp[j].size();
					dp[i] = new ArrayList<Integer>(dp[j]);
					dp[i].add(0, arr[i]);
				}
			}
			if (dp[i].size() > totalMaxLen) {
				totalMaxLen = dp[i].size();
				lis = dp[i];
			}
		}
		return lis;
	}
	
	/*
	 * DP : convert to LCS, lis(arr) = lcs(arr, arr*), arr* = sort(arr)
	 */
	public static List<Integer> lis2(int[] arr) {
		
		return null;
	}	
}
