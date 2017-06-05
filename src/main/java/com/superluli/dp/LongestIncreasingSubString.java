package com.superluli.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubString {

	public static void main(String[] args) {

		System.err.println(lis("XABCABCX"));
	}

	public static List<String> lis(String s) {

		List<String> list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		int maxLen = 0;

		int i = 0;
		while (i < s.length()) {

			int c = s.charAt(i);
			int j = i;

			while (j < s.length() && s.charAt(j) >= c) {
				sb.append(s.charAt(j));
				c = s.charAt(j);
				j++;
			}
			String subs = sb.toString();
			if (subs.length() == maxLen) {
				list.add(sb.toString());
			} else if (subs.length() > maxLen) {
				list.clear();
				maxLen = subs.length();
				list.add(sb.toString());
			}

			sb = new StringBuilder();
			i = j;
		}

		return list;
	}
}
