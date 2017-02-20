package com.superluli.sort;

import java.util.Arrays;

public class QuickSort implements Sort {

	public static void main(String[] args) {

		int[] arr = { 5, 1, 5, 7, 9, 2, 8, 1, 4, 6, 5 };
		System.err.println(new QuickSort().biPartition(arr, 0, arr.length-1, 5));
		System.err.println(Arrays.toString(arr));
	}

	/**
	 * Quick sort is unstable, in-place Avg O(nlgn) Worst O(n^2) Implementation
	 * issues : 1. choice of pivot : if array is almost sorted, degrade to
	 * O(n^2), because partition is uneven 2. repeated elements : if whole array
	 * has same elements, degrade to O(n^2), because partition is uneven
	 */
	@Override
	public int[] sort(int[] arr) {

		quickSort(arr, 0, arr.length - 1);
		return arr;
	}

	private void quickSort(int[] arr, int from, int to) {

		if (from >= to) {
			return;
		}
		// naive pivot selector, but can improve performance for almost sorted
		// array
		int pivot = arr[from] + (arr[to] - arr[from]) / 2;
		int index = biPartition(arr, from, to, pivot);
		quickSort(arr, from, index);
		quickSort(arr, index + 1, to);
	}

	/*
	 * Split a array into 2 parts, left part(include j) always <= pivot, right
	 * part always >= pivot
	 */
	public int biPartition(int[] arr, int from, int to, int pivot) {

		int i = from - 1, j = to + 1;
		while (true) {
			i++;
			j--;
			while (i < to && arr[i] < pivot) {
				i++;
			}
			while (j > from && arr[j] > pivot) {
				j--;
			}
			if (i >= j) {
				break;
			}
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return j;
	}
}
