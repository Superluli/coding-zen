package com.superluli.arr;

public class ReverseString {

	public static void main(String[] args) {

		System.err.println(reverseString(null));
		System.err.println(reverseString(""));
		System.err.println(reverseString("a"));
		System.err.println(reverseString("ab"));
		System.err.println(reverseString("aba"));
		System.err.println(reverseString("abcdefg"));
	}

	public static String reverseString(String s) {

		if (s == null) {
			return null;
		}

		char[] charArray = s.toCharArray();
		int i = 0, j = charArray.length - 1;
		while (i < j) {
			char c = charArray[i];
			charArray[i++] = charArray[j];
			charArray[j--] = c;
		}
		return new String(charArray);
	}
}
