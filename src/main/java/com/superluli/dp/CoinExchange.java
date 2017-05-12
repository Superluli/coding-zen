package com.superluli.dp;

/**
 * Given unlimited number of quarters, dimes, nickels and cents, how many ways
 * can N cents be exchanged
 * 
 * @author Lu
 *
 */
public class CoinExchange {

	public static void main(String[] args) {
		for (int i = 1; i < 20; i++) {
			System.err.println(i + ":" + getNumOfExchange(i));
		}
	}

	public static int getNumOfExchange(int n) {

		int[] arr = { 25, 10, 5, 1 };
		return getNumOfExchangeHelper(n, 0, arr);
	}

	public static int getNumOfExchangeHelper(int n, int index, final int[] arr) {

		if (index == 3 || n < 5)
			return 1;

		int i = index;
		while (arr[i] > n) {
			i++;
		}
		int k = n / arr[i];
		int sum = 0;
		while (k >= 0) {
			sum += getNumOfExchangeHelper(n - k * arr[i], i + 1, arr);
			k--;
		}
		return sum;
	} 
}
