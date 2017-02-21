package com.superluli.nonComparison;

import com.superluli.sort.Sort;

/**
 * Used for sorting that with a limited range and variants of values, string
 * sorting is a perfect use case O(K+N)
 * 
 * @author Lu
 *
 */
public class CountingSort implements Sort {

	@Override
	public int[] sort(int[] arr) {

		if (arr == null || arr.length == 0) {
			return arr;
		}

		int max = Integer.MIN_VALUE;
		for (int i : arr) {
			max = i > max ? i : max;
		}
		int[] counts = new int[max + 1];
		for (int i : arr) {
			counts[i]++;
		}

		int index = 0;
		for (int i = 0; i < counts.length; i++) {
			int count = counts[i];
			for (int j = 0; j < count; j++) {
				arr[index++] = i;
			}
		}

		return arr;
	}
}
