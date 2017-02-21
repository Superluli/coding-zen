package com.superluli.sort;


public class MergeSort implements Sort {

	@Override
	public int[] sort(int[] arr) {

		mergeSort(arr, 0, arr.length - 1);
		return arr;
	}

	public void mergeSort(int[] arr, int from, int to) {

		if (from >= to) {
			return;
		}

		int middle = from + (to - from) / 2;

		mergeSort(arr, from, middle);
		mergeSort(arr, middle + 1, to);
		// left size >= right size
		merge(arr, from, middle, middle + 1, to);
	}

	public void merge(int[] arr, int leftFrom, int leftTo, int rightFrom,
			int rightTo) {

		int[] temp = new int[rightTo - leftFrom + 1];
		int index = 0;
		int i = leftFrom, j = rightFrom;
		while (i <= leftTo && j <= rightTo) {
			if (arr[i] <= arr[j]) {
				temp[index++] = arr[i++];
			} else {
				temp[index++] = arr[j++];
			}
		}
		if (i > leftTo) {
			while (j <= rightTo) {
				temp[index++] = arr[j++];
			}
		}
		if (j > rightTo) {
			while (i <= leftTo) {
				temp[index++] = arr[i++];
			}
		}
		System.arraycopy(temp, 0, arr, leftFrom, temp.length);
	}
}
