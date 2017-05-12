package com.superluli.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {

		List<List<Integer>> fullPermutations = printFullPermutations(new int[] {
				1, 1, 3 });

		for (List<Integer> r : fullPermutations) {
			System.out.println(r);
		}

		List<List<Integer>> fullPermutations2 = printFullPermutations2(new int[] {
				1, 1, 2 });

		for (List<Integer> r : fullPermutations2) {
			System.out.println(r);
		}

		System.err.println(getPermutation(3, 4));
	}

	/*
	 * full permutations, given [a,b,c], return [[a,b,c], [a,c,b], [b,c,a],
	 * [b,a,c], [c,a,b], [c,b,a]]
	 */

	public static List<List<Integer>> printFullPermutations(int[] arr) {

		List<List<Integer>> results = new LinkedList<List<Integer>>();
		printFullPermutationsRecursively(results, arr, 0);
		return results;
	}

	public static void printFullPermutationsRecursively(
			List<List<Integer>> results, int[] arr, int from) {

		if (from == arr.length - 1) {
			List<Integer> list = new ArrayList<Integer>();
			for (int t : arr) {
				list.add(t);
			}
			results.add(list);
			return;
		}

		for (int i = from; i < arr.length; i++) {
			// swap arr[from] and arr[i]
			if (i == from || arr[i] != arr[from]) {
				swap(arr, from, i);
				printFullPermutationsRecursively(results, arr, from + 1);
				// swap back
				swap(arr, from, i);
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static List<List<Integer>> printFullPermutations2(int[] arr) {

		List<List<Integer>> results = new LinkedList<List<Integer>>();

		Arrays.sort(arr);

		boolean nextFound = true;
		while (nextFound) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i : arr) {
				list.add(i);
			}
			results.add(list);
			nextFound = nextPermutation(arr);
		}
		return results;
	}

	/*
	 * from right to left, find first decreasing number i, and j which is
	 * smallest number that >= i on i's right switch i and j sort numbers after
	 * i
	 */
	public static boolean nextPermutation(int[] arr) {

		int len = arr.length;
		int i = len - 2;
		// find i
		while (i >= 0 && arr[i] >= arr[i + 1]) {
			i--;
		}
		if (i < 0) {
			return false;
		}

		// find j
		int j = len - 1;
		while (arr[j] <= arr[i]) {
			j--;
		}
		// swap arr[i] and arr[j]
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

		// reverse sub-array from arr[i+1]
		j = i + 1;
		int k = len - 1;

		while (k > j) {
			temp = arr[j];
			arr[j++] = arr[k];
			arr[k--] = temp;
		}

		return true;
	}

	/*
	 * 312 -> 321 -> 123 (start from beginning again)
	 */
	public static boolean nextPermutationEndless(int[] arr) {

		int len = arr.length;
		int i = len - 2, j = len - 1, temp = 0;
		// find i
		while (i >= 0 && arr[i] >= arr[i + 1]) {
			i--;
		}
		if (i >= 0) {
			// find j
			while (arr[j] <= arr[i]) {
				j--;
			}
			// swap arr[i] and arr[j]
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}

		// reverse sub-array from arr[i+1]
		j = i + 1;
		int k = len - 1;

		while (k > j) {
			temp = arr[j];
			arr[j++] = arr[k];
			arr[k--] = temp;
		}

		return true;
	}

	public static String getPermutation(int n, int k) {

		StringBuilder sb = new StringBuilder();
		boolean[] ranks = new boolean[n];
		int i = n - 1;
		int fac = getFactorial(i);
		while (i >= 0) {
			int rank = (k - 1) / fac + 1;
			int num = findNum(ranks, rank);
			sb.append(num);
			ranks[num-1] = true;
			k -= fac * (rank - 1);
			if (i != 0) {
				fac /= i;
			}
			i--;
		}
		return sb.toString();
	}

	private static int findNum(boolean[] ranks, int rank) {

		int numFound = 0;
		int i = 0;
		while(i < ranks.length){
			if (!ranks[i]) {
				numFound++;
				if (numFound == rank) {
					break;
				}
			}
			i++;
		}
		return i + 1;
	}

	private static int getFactorial(int n) {

		int r = 1;
		for (int i = n; i >= 1; i--) {
			r *= i;
		}
		return r;
	}
}
