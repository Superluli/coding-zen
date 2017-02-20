package com.superluli.strings;

public class ReverseSentense {

	public static void main(String[] args) {

		System.err.println(reverseSentence(""));
		System.err.println(reverseSentence("I am a super hero"));
		System.err.println(reverseSentence("Im"));
	}

	public static String reverseSentence(String s) {

		if (s == null) {
			return null;
		}

		char[] arr = s.toCharArray();

		reverseCharArr(arr, 0, arr.length - 1);

		int from = 0, to = 0;

		while (to < arr.length) {

			if (arr[to] == ' ') {
				reverseCharArr(arr, from, to - 1);
				from = to + 1;
			}
			
			if (to == arr.length - 1) {
				reverseCharArr(arr, from, to);
			}
			
			to++;
		}

		return new String(arr);
	}

	public static void reverseCharArr(char[] arr, int from, int to) {

		int i = from, j = to;
		while (i < j) {
			char c = arr[i];
			arr[i++] = arr[j];
			arr[j--] = c;
		}
	}
}
