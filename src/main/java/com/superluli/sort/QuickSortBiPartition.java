package com.superluli.sort;


public class QuickSortBiPartition implements Sort {

	public static void main(String[] args) {

	}

	@Override
	public String getName() {
		return "Quick Sort - Bi partition";
	}
	
	/**
	 * Quick sort is unstable, in-place Avg O(nlgn) Worst O(n^2) Implementation
	 * issues : 1. choice of pivot : if array is almost sorted, degrade to
	 * O(n^2), because partition is uneven, solution : median of medians 2.
	 * repeated elements : if whole array has same elements, degrade to O(n^2),
	 * because partition is uneven, solution : 3-way partitioning
	 */
	@Override
	public int[] sort(int[] arr) {

		quickSortBiPartition(arr, 0, arr.length - 1);
		return arr;
	}

	private void quickSortBiPartition(int[] arr, int from, int to) {

		if (from >= to) {
			return;
		}
		// naive pivot selector, but can improve performance for almost sorted
		// array
		int pivot = arr[from] + (arr[to] - arr[from]) / 2;
		int index = biPartition(arr, from, to, pivot);
		quickSortBiPartition(arr, from, index);
		quickSortBiPartition(arr, index + 1, to);
	}

	/*
	 * Split an array into 2 parts, left part(include j) always <= pivot, right
	 * part always >= pivot
	 */
	public static int biPartition(int[] arr, int from, int to, int pivot) {

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
