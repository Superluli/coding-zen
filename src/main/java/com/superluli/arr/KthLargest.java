package com.superluli.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import com.superluli.sort.QuickSort;

public class KthLargest {

	public static Random RND = new Random();

	public static void main(String[] args) {

		System.err.println(kthLargest5(new int[] { 5, 2, 4, 1, 3, 6, 0 }, 4));
		// funtionTest();
		// performanceTest();
	}

	public static void funtionTest() {

		int[][] nums = new int[5][];

		nums[0] = new int[] { 5, 2, 4, 1, 3, 6, 0 };
		nums[1] = new int[] { -1, 2, 0 };
		nums[2] = new int[] { 9, 7, 2, 5, 6, 10, 1, 4, 8, 3 };
		nums[3] = new int[] { 1, 1, 1, 1, 1 };
		nums[4] = new int[] { 1, 8, 1, 1, 5 };

		for (int[] arr : nums) {
			for (int i = 1; i <= arr.length; i++) {
				System.err.println(i + " th largest element of "
						+ Arrays.toString(arr) + " : " + kthLargest5(arr, i));
			}
		}
	}

	public static void performanceTest() {

		int num = 100 * 100;

		List<int[]> list = new ArrayList<int[]>(1000);

		for (int n = 0; n < 1000; n++) {
			int[] arr = new int[num];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = RND.nextInt(num) + 1;
			}
			list.add(arr);
		}

		long t1 = System.currentTimeMillis();
		for (int[] arr : list) {
			for (int r = 0; r < 10; r++) {
				kthLargest5(arr, RND.nextInt(num / 2) + 1);
				// kthLargest4(arr, 50);
			}
		}
		System.err
				.println("Perf result : " + (System.currentTimeMillis() - t1));

		list.clear();
		for (int n = 0; n < 1000; n++) {
			int[] arr = new int[num];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = RND.nextInt(num) + 1;
			}
			list.add(arr);
		}

		t1 = System.currentTimeMillis();
		for (int[] arr : list) {
			for (int r = 0; r < 10; r++) {
				kthLargest1(arr, RND.nextInt(num / 2) + 1);
				// kthLargest5(arr, 50);
			}
		}
		System.err
				.println("Perf result : " + (System.currentTimeMillis() - t1));
	}

	/*
	 * sort, O(nlgn)
	 */
	public static int kthLargest1(int[] nums, int k) {

		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	/*
	 * put first K largest number in first part of array if(i < max) : swap (i,
	 * max) O(n*k)
	 */
	public static int kthLargest2(int[] nums, int k) {

		int maxFound = 0;
		while (maxFound < k) {
			// find indexOfNextLargest
			int indexOfNextLargest = maxFound;
			int max = Integer.MIN_VALUE;
			for (int i = maxFound; i < nums.length; i++) {
				if (nums[i] > max) {
					indexOfNextLargest = i;
					max = nums[i];
				}
			}
			// swap nums[indexOfNextLargest] and nums[maxFound]
			int temp = nums[maxFound];
			nums[maxFound] = nums[indexOfNextLargest];
			nums[indexOfNextLargest] = temp;
			maxFound++;
		}
		return nums[maxFound - 1];
	}

	/*
	 * Maintain a min heap, if num > minHeap.min, replace minHeap.min with num
	 */
	public static int kthLargest4(int[] nums, int k) {

		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		// construct heap
		for (int i = 0; i < k; i++) {
			q.add(nums[i]);
		}

		for (int i = k; i < nums.length; i++) {
			int nextMin = q.peek();
			if (nextMin < nums[i]) {
				q.poll();
				q.add(nums[i]);
			}
		}

		return q.peek();
	}

	/*
	 * QuickSelect, O(n)
	 */
	public static int kthLargest5(int[] nums, int k) {

		return kthLargest5(nums, 0, nums.length - 1, k);
	}

	private static int kthLargest5(int[] nums, int from, int to, int k) {

		if (from >= to) {
			return nums[from];
		}

		int pivot = nums[from] + (nums[to] - nums[from]) / 2;
		int index = new QuickSort().biPartition(nums, from, to, pivot);

		int largerPartSize = to - index;
		if (largerPartSize >= k) {
			return kthLargest5(nums, index + 1, to, k);
		} else {
			return kthLargest5(nums, from, index, k - largerPartSize);
		}
	}
}
