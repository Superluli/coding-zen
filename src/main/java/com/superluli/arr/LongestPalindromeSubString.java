package com.superluli.arr;

import java.util.Random;

public class LongestPalindromeSubString {

	public static final Random RND = new Random();

	public static void main(String[] args) {

		StringBuilder s = new StringBuilder();
		
		for(int i = 0; i < 100; i++){
			s.append(generateRandomString(i*i));
			s.append(generatePalindrome(i));
		}
		
		System.err.println(solution1(s.toString()));
	}

	public static String generateRandomString(int n){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++){
			sb.append(randomChar());
		}
		return sb.toString();
	}
	
	public static String generatePalindrome(int n) {

		char[] arr = new char[n];

		int i = 0, j = n - 1;
		while (i < j) {
			char c = randomChar();
			arr[i++] = c;
			arr[j--] = c;
		}
		
		if((n&1) == 1){
			arr[(n-1)/2] = randomChar();
		}
		
		return new String(arr);
	}

	public static char randomChar() {
		return (char) (RND.nextInt(0X007A - 0X0061 + 1) + 0X0061);
	}

	public static int solution1(String s) {

		if (s == null) {
			return 0;
		}

		char[] arr = s.toCharArray();
		int maxLen = 0, len = s.length();

		for (int i = 0; i < len; i++) {

			int j = i, k = i;
			while (j >= 0 && k < len && arr[j] == arr[k]) {
				j--;
				k++;
			}
			maxLen = Math.max(maxLen, k - j - 1);
			j = i;
			k = i + 1;
			while (j >= 0 && k < len && arr[j] == arr[k]) {
				j--;
				k++;
			}
			maxLen = Math.max(maxLen, k - j - 1);
		}
		return maxLen;
	}
}
