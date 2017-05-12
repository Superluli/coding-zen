package com.superluli.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class KingOfWater {

	public static void main(String[] args) {

		int[] arr = new int[] { 4, 3, 4, 2, 3, 1, 2 };
		System.err.println(findSingleElementOthersTwice(arr));
		arr = new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE,
				Integer.MAX_VALUE, Integer.MAX_VALUE };
		System.err.println(findSingleElementOthers3Times(arr));
		arr = new int[] { 1, 2, 3, 4, 2, 5, 3, 1 };
		System.err.println(findFirstSingleElement(arr));
		arr = new int[] { 1, 2, 1, 1, 2};
		System.err.println(findElementAppearsMoreThanHalf(arr));
		arr = new int[] { 2, 1, 1, -3, -6, 1};
		System.err.println(findElementAppearsHalf(arr));
	}

	/*
	 * in arr only 1 element appears once, all others appears twice, find the
	 * single one
	 */
	public static int findSingleElementOthersTwice(int[] arr) {

		int single = 0;
		for (int i : arr) {
			single ^= i;
		}

		return single;
	}

	/*
	 * in arr only 1 element appears once, all others appears 3 times, find the
	 * single one. Solution : We can sum the bits in same positions for all the
	 * numbers and take modulo with 3. The bits for which sum is not multiple of
	 * 3, are the bits of number with single occurrence.
	 */
	public static int findSingleElementOthers3Times(int[] arr) {

		int m = 1;
		int result = 0;
		for (int digit = 0; digit < 32; digit++) {
			if (digit != 0)
				m *= 2;
			int numInDigit = 0;
			for (int num : arr)
				numInDigit += (num >> digit) & 1;
			result += (numInDigit % 3) * m;
		}

		return result;
	}

	/*
	 * in arr find the 1st element that appears only once
	 */
	public static int findFirstSingleElement(int[] arr) {

		Map<Integer, Integer> firstIndexes = new HashMap<Integer, Integer>();
		TreeSet<Integer> indexes = new TreeSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			if (firstIndexes.containsKey(num)) {
				indexes.remove(firstIndexes.get(num));
			} else {
				firstIndexes.put(num, i);
				indexes.add(i);
			}
		}

		return arr[indexes.first()];
	}

	/*
	 * Find element that appears more than half the array size
	 */
	public static int findElementAppearsMoreThanHalf(int[] arr) {
		int times = 1, num = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (times == 0)
				num = arr[i];
			if (arr[i] == num)
				times++;
			else
				times--;
		}
		return num;
	}

	/*
	 * Find element that appears half the array size
	 */
	public static int findElementAppearsHalf(int[] arr) {
		Arrays.sort(arr);
		int m1 = arr[arr.length/2-1];
		int m2 = arr[arr.length/2-1];
		return (m1 == m2 || m1 == arr[0]) ? m1 : m2;
	}
}
