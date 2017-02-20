package com.superluli.sort.slow;

import com.superluli.sort.Sort;

public class SelectionSort implements Sort {

	@Override
	public int[] sort(int[] arr) {

		int sorted = 0;

		while (sorted < arr.length) {
			//find min from sorted to arr.length -1, swap arr[sorted] and min
			int min = Integer.MAX_VALUE;
			int minIndex = sorted;
			for(int i = sorted; i < arr.length; i++){
				if(arr[i] < min){
					min = arr[i];
					minIndex = i;
				}
			}
			arr[minIndex] = arr[sorted];
			arr[sorted++] = min;
		}

		return arr;
	}
}
