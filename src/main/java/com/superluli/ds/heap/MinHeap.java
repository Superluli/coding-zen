package com.superluli.ds.heap;

public interface MinHeap {

	/*
	 * Insert a value
	 */
	void insert(int v);

	/*
	 * Replace top of heap
	 */
	void replaceMin(int v);

	/*
	 * Return top of heap
	 */
	public int getMin();
}
