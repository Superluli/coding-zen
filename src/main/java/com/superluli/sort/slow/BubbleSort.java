package com.superluli.sort.slow;

import com.superluli.sort.Sort;

public class BubbleSort implements Sort {

	@Override
	public int[] sort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			boolean sortDone = true;
			for (int j = 0; j < arr.length - 1 - i; j++) {

				if (arr[j] > arr[j + 1]) {
					sortDone = false;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (sortDone) {
				break;
			}
		}
		return arr;
	}
}
