package com.superluli.sort;

/**
 * Shell sort is a optimization of Insertion sort.
 * choose a series of gaps, for each gap, sort all partitions of arr using
 * insertion sort, gap series must contain 1
 * 
 * @author Lu
 *
 */
public class ShellSort implements Sort {

	@Override
	public int[] sort(int[] arr) {

		int[] gaps = { 255, 127, 63, 37, 15, 7, 3, 1 };
		for (int gap : gaps) {
			// each sub-array start from i
			for (int i = 0; i < gap; i++) {
				// selection sort
				for (int j = i + gap; j < arr.length; j += gap) {
					int k = j - gap;
					while (k >= i && arr[k] > arr[j]) {
						arr[k + gap] = arr[k];
						k -= gap;
					}
					arr[k + gap] = arr[j];
				}
			}
		}
		return arr;
	}
}
