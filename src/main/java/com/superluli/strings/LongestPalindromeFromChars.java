package com.superluli.strings;


public class LongestPalindromeFromChars {

	public static void main(String[] args) {

		System.err.println(solution1("a"));
		System.err.println(solution1("ab"));
		System.err.println(solution1("aba"));
		System.err.println(solution1("aaaa"));
		System.err.println(solution1("aaaab"));
	}

	public static int solution1(String s) {

		/**
		 * A character map that stores keys A-Z and a-c, and value of a boolean
		 * meaning whether this character exists
		 * 
		 * @author Lu
		 *
		 */
		boolean[] map = new boolean[58]; 
		int maxLen = 0, count = 0;	
		for (char c : s.toCharArray()) {
			int i = c-'A';
			if (map[i]) {
				maxLen += 2;
				map[i] = false;
				count --;
			} else {
				map[i] = true;
				count ++;
			}
		}
		if(count > 0){
			maxLen += 1;
		}
		return maxLen;
	}

	public static int solution2(String s) {

		/**
		 * A character map that stores keys A-Z and a-c, and value of a boolean
		 * meaning whether this character exists
		 * 
		 * @author Lu
		 *
		 */
		long map = 0L;
		int maxLen = 0;
		for (char c : s.toCharArray()) {
			int i = c-'A';
			if (((map >> i) & 1) == 1) {
				maxLen += 2;
				map &= (~(1L << i))&0x7FFFFFFFFFFFFFFFL;
			} else {
				map |= 1L << i;
			}
		}
		if (map > 0) {
			maxLen += 1;
		}
		return maxLen;
	}
}
