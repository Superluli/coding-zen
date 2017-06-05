package com.superluli.bits;

public class Power {

	public static void main(String[] args) {

		System.err.println(power(2.0, -2));
	}

	public static double power(double x, int y) {

		double result = 1;
		double base = x;
		int power = y;

		if (y < 0) {
			base = 1.0 / x;
			power = -y;
		}

		while (power > 0) {
			// odd
			if ((power & 1) == 1) {
				result *= base;
			}
			// even
			base *= base;
			power >>>= 1;
		}
		return result;
	}
}
