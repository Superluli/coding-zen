package com.superluli.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * given n and k, find all combinations from [1, 2, ...n] that sums up to k
 * 
 * @author Lu
 *
 */
public class KSum {

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		System.err.println("found : " + kSum1(100,80).size());
		System.err.println(System.currentTimeMillis() - t1);
	}
	
	/*
	 * DP, 01 backpack, kSum(n,k) = kSum(n-1, k-n) + kSum(n-1,k)
	 */
	public static List<List<Integer>> kSum1(int n, int k) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		kSum1(n, k, list, new ArrayList<Integer>());
		
		return list;
	}

	public static void kSum1(int n, int k, List<List<Integer>> list,
			List<Integer> tempList) {

		// termination condition, sum is 0
		if (k == 0) {
			list.add(new ArrayList<Integer>(tempList));
			return;
		}

		if (k < 0 || n <= 0) {
			return;
		}

		// not count n
		kSum1(n - 1, k, list, tempList);

		// count n
		tempList.add(n);
		kSum1(n - 1, k - n, list, tempList);
		tempList.remove(tempList.size()-1);
	}

	/*
	 * Backtracking
	 */
	public static List<List<Integer>> kSum2(int n, int k) {
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		return list;
	}
}
