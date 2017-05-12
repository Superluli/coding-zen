package com.superluli.sort;

import java.util.PriorityQueue;

public class HeapSort implements Sort {

	@Override
	public String getName() {
		return "Heap Sort";
	}
	
	@Override
	public int[] sort(int[] arr) {

		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int t : arr) {
			q.add(t);
		}

		int i = 0;
		Integer v = null;
		while ((v = q.poll()) != null) {
			arr[i++] = v;
		}
		return arr;
	}
}
