package com.superluli.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.superluli.sort.slow.InsersionSort;

public class Test {

	private static Random RND = new Random();

	public static void main(String[] args) {

		
		Sort s1 = new ShellSort();
		Sort s2 = new QuickSort();
		Sort s3 = new HeapSort();
		Sort s4 = new InsersionSort();
		
		
		funcTest(s3);
		
		perfTest(s1);
		perfTest(s2);
		perfTest(s3);
		perfTest(s4);
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

		for (int[] arr : list) {
			System.err.print(Arrays.toString(arr) + " -> ");
			System.err.println(Arrays.toString(s.sort(arr)));
		}

		int round = 0;
		while (round++ < 1000) {
			int size = RND.nextInt(5);
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = RND.nextInt(5) - 5;
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

		long t1 = System.currentTimeMillis();
		int round = 0;
		while (round++ < 10) {
			int size = RND.nextInt(500000);
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = RND.nextInt(1000000);
			}
			arr = s.sort(arr);
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] < arr[i - 1]) {
					System.err.println(Arrays.toString(arr));
				}
			}
		}
		System.err.println(System.currentTimeMillis() - t1);
	}
}
