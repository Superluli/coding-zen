package com.superluli.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Median of medians algorithm, find APPROXIMATE median of unsorted array in
 * linear time can be used for pivot selection of quicksort
 * 
 * @author Lu
 *
 */
public class MedianSelect {

	public static void main(String[] args) {

		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(10);
		}
		arr = new int[]{1,1,1,1,3,3,5,6,7};
		System.err.println(getMedian(arr, 0, 5));
	}

	public static int getMedian(int[] arr, int from, int to) {

		to = Math.min(to, arr.length - 1);
//		
//		System.err.print("arr : " + Arrays.toString(arr) + " from : " + from
//				+ " to : " + to);
		
		int size = to - from + 1;

		if (size <= 5) {
			// return directly
			Arrays.sort(arr, from, to + 1);
			int median = arr[from + size / 2];
			return median;
		}

		int[] medians = new int[(size + 4) / 5];
		
		int index = 0;
		for (int i = from; i <= to; i += 5) {
			medians[index++] = getMedian(arr, i, Math.min(i + 4, to));
		}

		return getMedian(medians, 0, medians.length - 1);
	}
}
