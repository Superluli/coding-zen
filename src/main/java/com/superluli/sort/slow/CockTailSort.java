package com.superluli.sort.slow;

import com.superluli.sort.Sort;

public class CockTailSort implements Sort {

	@Override
	public int[] sort(int[] arr) {

		int left = 0, right = arr.length - 1;
		while (left < right) {
			boolean sortDone = true;
			for (int j = left; j < right; j++) {
				if (arr[j] > arr[j + 1]) {
					sortDone = false;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			right --;
			for (int j = right; j > left; j--) {
				if (arr[j] < arr[j - 1]) {
					sortDone = false;
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
			left ++;
			if (sortDone) {
				break;
			}
		}
		return arr;
	}

}
