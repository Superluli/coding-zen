package com.superluli.arr;

/**
 * given array, check if a subset can sum up to k
 * 
 * @author Lu
 *
 */
public class AnySum {

	public static void main(String[] args) {

		int[] arr = {1,2,3};
		
		System.err.println(anySum(arr, 7));
	}

	public static boolean anySum(int[] arr, int k) {

		return anySum(arr, k, 0);
	}

	private static boolean anySum(int[] arr, int k, int from) {

		if(from >= arr.length){
			return false;
		}
		
		if(arr[from] == k){
			return true;
		}
		
		boolean result = false;
		for (int i = from; i < arr.length; i++) {

			result |= anySum(arr, k, i + 1);
			result |= anySum(arr, k-arr[i], i+1);
		}

		return result;
	}
}
