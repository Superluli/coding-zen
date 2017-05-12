package com.superluli.sort.slow;

import com.superluli.sort.Sort;

public class GnomeSort implements Sort {

	@Override
	public String getName() {
		return "Gnome Sort";
	}
	
	@Override
	public int[] sort(int[] arr) {

		int i = 1;
		while (i < arr.length) {
			if (i ==0 || arr[i] >= arr[i - 1]) {
				i++;
			} else {
				int temp = arr[i];
				arr[i] = arr[i - 1];
				arr[i - 1] = temp;
				i--;
			}
		}
		return arr;
	}
}
