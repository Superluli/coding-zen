package com.superluli.sort.nonComparison;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.superluli.sort.Sort;

/**
 * O(K*N), K is number of digits
 * 
 * @author Lu
 *
 */
public class RadixSort implements Sort {

	@Override
	public int[] sort(int[] arr) {

		Object[] buckets = new Object[10];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		
		int[] result = new int[arr.length];
		boolean sorted = false;
		int index = 0;
		int digit = 0;
		int j = arr.length;
		while (!sorted) {

			sorted = true;
			//for current values in array, put to final result or bucket
			for (int i = 0; i < j; i++) {
				int v = arr[i];
				int d = getDigit(v, digit);
				// if digit doesn't exist, add to final result
				if (d == -1) {
					result[index++] = v;
				}
				// else put to buckets
				else {
					sorted = false;
					List<Integer> list = (List<Integer>) (buckets[d]);
					list.add(v);
				}
			}

			if (sorted) {
				break;
			}

			j = 0;
			// put values back to arr
			for (int i = 0; i < buckets.length; i++) {
				List<Integer> list = (List) buckets[i];
				Iterator<Integer> ite = list.iterator();
				while (ite.hasNext()) {
					int v = ite.next();
					arr[j++] = v;
				}
				list.clear();
			}
			
			digit++;
		}

		return result;
	}

	/*
	 * Get digit in LSD order, n start from 0, -1 means digit doesn't exist
	 */
	public static int getDigit(int num, int n) {

		if (num == 0) {
			return n == 0 ? 0 : -1;
		}

		int d = 1;
		for (int i = 0; i < n; i++) {
			d *= 10;
		}
		if (d > num) {
			return -1;
		}
		return (num % (d * 10)) / d;
	}

	@Override
	public String getName() {
		return "Radix Sort";
	}
}
