package com.superluli.nonComparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.superluli.sort.Sort;

/**
 * use a index = f(v) each v in array to a index of group of buckets (like
 * hash), if(v1 < v2), must have f(v1) <= f(v2), then just traverse buckets and
 * sort elements in each bucket, use case is same as CountingSort, in my opinion
 * it's a optimization of counting sort when range is large(but still limited)
 * 
 * @author Lu
 *
 */
public class BucketSort implements Sort {

	private static int MOD = 10000;

	@Override
	public int[] sort(int[] arr) {
		List<List<Integer>> buckets = new ArrayList<List<Integer>>(MOD);
		for (int i = 0; i < MOD; i++) {
			buckets.add(new ArrayList<Integer>());
		}
		for (int v : arr) {
			buckets.get(getBucket(v)).add(v);
		}

		int i = 0;
		for (List<Integer> bucket : buckets) {
			sortInBucket(bucket);
			for (int v : bucket) {
				arr[i++] = v;
			}
		}

		return arr;
	}

	public int getBucket(int v) {
		return v % MOD;
	}

	public void sortInBucket(List<Integer> list) {

		Collections.sort(list);
	}
}
