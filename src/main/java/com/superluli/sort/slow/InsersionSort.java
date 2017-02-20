package com.superluli.sort.slow;

import com.superluli.sort.Sort;

/**
 * O(n^2), easy implementation, stable, online(stream), adaptive
 * 
 * @author Lu
 *
 */
public class InsersionSort implements Sort{

	@Override
	public int[] sort(int[] arr) {
		
		int i = 1;
		while (i < arr.length) {
			int v = arr[i];
			int j = i-1;
			while(j >= 0 && arr[j] > v){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = v;
			i++;
		}
		return arr;
	}
}
