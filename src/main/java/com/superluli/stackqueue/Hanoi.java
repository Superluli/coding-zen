package com.superluli.stackqueue;


public class Hanoi {

	public static void main(String[] args) {

		hanoi(3, "A", "C", "B");
	}

	public static void hanoi(int n, String from, String to, String buffer) {

		if (n == 0)
			return;
		hanoi(n - 1, from, buffer, to);
		System.err.println(n + " : " + from + " -> " + to);
		hanoi(n - 1, buffer, to, from);
	}
}
