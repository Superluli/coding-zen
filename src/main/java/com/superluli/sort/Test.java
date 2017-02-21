package com.superluli.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.superluli.nonComparison.BucketSort;
import com.superluli.nonComparison.CountingSort;
import com.superluli.nonComparison.RadixSort;

public class Test {

	private static Random RND = new Random();

	public static void main(String[] args) {

		Sort s0 = new CountingSort();
		Sort s1 = new ShellSort();
		Sort s2 = new QuickSort();
		Sort s3 = new MergeSort();
		Sort s4 = new HeapSort();
		Sort s5 = new RadixSort();
		
//		funcTest(s5);
		perfTest(s0);
		perfTest(s1);
		perfTest(s2);
		perfTest(s3);
		perfTest(s4);
		perfTest(s5);
	}

	public static void funcTest(Sort s) {

		List<int[]> list = new ArrayList<int[]>();
		list.add(new int[] {});
		list.add(new int[] { 0, 0, 0, 0, 0 });
		list.add(new int[] { 1, 2, 3 });
		list.add(new int[] { 2, 1, 3 });
		list.add(new int[] { 3, 1, 2 });
		list.add(new int[] { 3, 2, 1 });
		list.add(new int[] { 3, 2, 1, 2 });
		list.add(new int[] { 3, 12, 1, 10, 2, 0 });

		for (int[] arr : list) {
			System.err.print(Arrays.toString(arr) + " -> ");
			System.err.println(Arrays.toString(s.sort(arr)));
		}

		int round = 0;
		while (round++ < 1000) {
			int size = RND.nextInt(5);
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = RND.nextInt(10);
			}
			arr = s.sort(arr);
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] < arr[i - 1]) {
					System.err.println("WRONG : " + Arrays.toString(arr));
				}
			}
		}
		System.err.println("All func tests passed!");
	}

	public static void perfTest(Sort s) {

		List<int[]> list = new ArrayList<int[]>();
		int round = 0;		
		while (round++ < 100) {
			int size = RND.nextInt(1000000);
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = RND.nextInt(10000);
			}
			list.add(arr);
		}
		
		long t1 = System.currentTimeMillis();
		for (int[] arr : list) {
			arr = s.sort(arr);
		}
		
		System.err.println(System.currentTimeMillis() - t1);
	}
}
