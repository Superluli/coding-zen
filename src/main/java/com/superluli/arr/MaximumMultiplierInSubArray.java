package com.superluli.arr;

/**
 * Given array of double, find subarray with maximum multiply
 * 
 * @author Lu
 * 
 *         max(i) = max multipler for subarray that ending at i min(i) = min
 *         multipler for subarray that ending at i
 * 
 *         State transfer formula: max(i) = max(arr[i], max(i-1)*arr[i],
 *         min(i-1)*arr[i]) min(i) = min(arr[i], max(i-1)*arr[i],
 *         min(i-1)*arr[i]) max(0) = min(0) = 1
 */
public class MaximumMultiplierInSubArray {

	public static void main(String[] args) {

		double[] arr = new double[] { -2, 10, 2, 0.5, -0.4 };
		System.err.println(maximumMultiplierInSubArray(arr));
	}

	public static double maximumMultiplierInSubArray(double[] arr) {

		double[] max = new double[arr.length + 1];
		double[] min = new double[arr.length + 1];
		max[0] = min[0] = 1;

		double finalMax = 0;
		for (int i = 1; i < arr.length + 1; i++) {

			double d = arr[i - 1];
			max[i] = Math.max(Math.max(d, max[i - 1] * d), min[i - 1] * d);
			min[i] = Math.min(Math.min(d, max[i - 1] * d), min[i - 1] * d);
			finalMax = Math.max(finalMax, max[i]);
		}
		return finalMax;
	}
}
