package com.superluli.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Note : 3 sum to 0, the solution set must not contain duplicate triplets.
 * 
 * @author Lu
 *
 */
public class ThreeSum {

	public static void main(String[] args) {

		System.err.println(new ThreeSum().threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}
	
	public List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);
		int[] cache1 = buildCache1(nums);
		int[] cache2 = buildCache2(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int i = 0;

		while (i < nums.length) {

			int num = nums[i];
			if (num > 0) {
				break;
			}

			List<List<Integer>> twoSums = twoSum(nums, 0 - num, i + 1,
					nums.length - 1, cache1, cache2);

			for (List<Integer> twoSum : twoSums) {
				twoSum.add(num);
				list.add(twoSum);
			}

			i = cache1[i];
		}
		return list;
	}

	/*
	 * If not found, return null
	 */
	public List<List<Integer>> twoSum(int[] nums, int sum, int from,
			int to, int[] cache1, int[] cache2) {

		List<List<Integer>> twoSums = new ArrayList<List<Integer>>();

		if ((from < nums.length - 1 && nums[from] + nums[from + 1] > sum)
				|| (to >= 1 && nums[to] + nums[to - 1] < sum)) {
			return twoSums;
		}

		while (from < to && from < nums.length && to >= 0) {
			int fromVal = nums[from];
			int toVal = nums[to];
			int s = fromVal + toVal;
			if (s == sum) {
				List<Integer> twoSum = new ArrayList<Integer>();
				twoSum.add(nums[from]);
				twoSum.add(nums[to]);
				twoSums.add(twoSum);
				from = cache1[from];
				to = cache2[to];
			} else if (s < sum) {
				from = cache1[from];
			} else {
				to = cache2[to];
			}
		}
		return twoSums;
	}
	
	public int[] buildCache1(int[] nums){
		
		int[] arr = new int[nums.length];
		int i = 0;
		while(i < nums.length){
			int newI = i;
			int num = nums[i];
			while(newI < nums.length && nums[newI] == num){
				newI++;
			}
			while(i < newI){
				arr[i] = newI;
				i++;
			}
		}
		return arr;
	}
	
	public int[] buildCache2(int[] nums){
		
		int[] arr = new int[nums.length];
		int i = nums.length-1;
		while(i >= 0){
			int newI = i;
			int num = nums[i];
			while(newI >= 0 && nums[newI] == num){
				newI--;
			}
			while(i > newI){
				arr[i] = newI;
				i--;
			}
		}
		return arr;
	}
}
