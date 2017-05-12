package com.superluli.dp;

public class Fibonacci {

	public static void main(String[] args) {

		long t1 = System.currentTimeMillis();

		System.err.println(getFibonacci(45));
		
		long t2 = System.currentTimeMillis();
		
		System.err.println("time : " + (t2 - t1));
		
		System.err.println(getFibonacci2(45));
		
		long t3 = System.currentTimeMillis();
		
		System.err.println("time : " + (t3 - t2));
	}

	public static int getFibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return getFibonacci(n - 1) + getFibonacci(n - 2);
	}

	public static int getFibonacci2(int n) {
		
		int[] arr = {0,1};
		
		for(int i = 1; i < n; i++){
			int next = arr[0] + arr[1];
			arr[0] = arr[1];
			arr[1] = next;
		}
		
		return arr[1];
	}
}
