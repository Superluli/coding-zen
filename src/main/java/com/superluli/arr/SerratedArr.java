package com.superluli.arr;

import java.util.Arrays;

/**
 * Given an array, re-arrange elements so that A[0] <= A[1] >= A[2] <= A[3] >=
 * A[3] <= A[4]...
 * 
 * @author Lu
 *
 */
public class SerratedArr {

	public static void main(String[] args) {
		
		int[] a = new int[]{1,2,3,4,5,6,7,8,9};
		serratedArr(a);
		System.err.println(Arrays.toString(a));
	}

	public static void serratedArr(int[] a) {

		for (int i = 1; i < a.length; i++) {

			if ((i % 2 == 0 && a[i - 1] < a[i])
					|| (i % 2 == 1 && a[i - 1] > a[i])) {
				int t = a[i];
				a[i] = a[i-1];
				a[i-1] = t;
			}
		}
	}
}
