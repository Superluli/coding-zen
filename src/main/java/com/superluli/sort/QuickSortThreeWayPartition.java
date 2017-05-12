package com.superluli.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSortThreeWayPartition implements Sort {

	public static void main(String[] args) {

		List<int[]> list = new ArrayList<int[]>();
		list.add(new int[] { 1, 1, 1, 1 });
		list.add(new int[] { 1, 2, 5 });
		list.add(new int[] { 5, 2, 5 });
		list.add(new int[] { 5, 2, 1 });
		list.add(new int[] { 5, 1, 5, 1, 5 });
		list.add(new int[] { 8, 5, 8, 5 });
		list.add(new int[] { 5, 5, 8, 8 });
		list.add(new int[] { 5, 6, 7, 8 });
		list.add(new int[] { 8, 7, 6, 5 });
		list.add(new int[] { 8, 7, 6, 5, 1, 2, 9, 3, 5 });
		list.add(new int[] { 2, 5, 2, 5, 8, 8, 7, 6, 5 });
		list.add(new int[] { 1, 8, 5, 5, 3, 8, 7, 2, 5, 8, 5, 1 });

		for (int[] arr : list) {

			System.err.print(Arrays.toString(arr));
			int[] results = new QuickSortThreeWayPartition().threeWayPartition(
					arr, 0, arr.length - 1, 5);
			System.err.print(" -> " + Arrays.toString(arr));
			System.err.println(" results :  " + Arrays.toString(results));
		}
	}

	@Override
	public String getName() {
		return "Quick Sort - 3 way partition";
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

		quickSortThreeWayPartition(arr, 0, arr.length - 1);
		return arr;
	}

	private void quickSortThreeWayPartition(int[] arr, int from, int to) {

		if (from >= to) {
			return;
		}
		// naive pivot selector, but can improve performance for almost sorted
		// array
		int pivot = arr[from] + (arr[to] - arr[from]) / 2;
		if (to - from <= 20000) {
			pivot = MedianSelect.getMedian(arr, from, to);
		}
		int[] indexes = threeWayPartition(arr, from, to, pivot);
		quickSortThreeWayPartition(arr, from, indexes[0]);
		quickSortThreeWayPartition(arr, indexes[1], to);
	}

	/*
	 * Split an array into 3 parts, left part[from,index1]always < pivot,
	 * [index1+1, index2-1] always = pivot, right part [index2, to] always >
	 * pivot
	 */
	public static int[] threeWayPartition(int[] arr, int from, int to, int pivot) {

		// i is end of left part
		int i = from;
		// j is start of right part
		int j = to;
		// k is end of middle part
		int k = from;

		while (k <= j) {

			// if arr[k] > p , swap (k, j--)
			if (arr[k] > pivot) {
				int temp = arr[k];
				arr[k] = arr[j];
				arr[j--] = temp;
			}
			// if arr[i] < p, swap (i++, k++)
			else if (arr[k] < pivot) {
				int temp = arr[k];
				arr[k++] = arr[i];
				arr[i++] = temp;
			}
			// if(arr[i] == p), k++
			else {
				k++;
			}
		}
		return new int[] { i - 1, j + 1 };
	}
}
