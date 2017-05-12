package com.superluli.search;

import java.util.Arrays;

public class BinarySearch implements Search {

	public static void main(String[] args) {

		int[] arr = { 0, 0, 0, 0, 0, 0, 0 };
		System.err.println(new BinarySearch().search(arr, 3));
	}

	@Override
	public int search(int[] nums, int num) {

		if (nums == null || nums.length == 0) {
			return -1;
		}
		Arrays.sort(nums);

		int from = 0, to = nums.length - 1;
		while (from <= to) {
			int middle = from + ((to - from) >> 1);
			if (nums[middle] > num) {
				to = middle - 1;
			} else if (nums[middle] < num) {
				from = middle + 1;
			}
			else {
				return middle;
			}
		}
		return -1;
	}
}
