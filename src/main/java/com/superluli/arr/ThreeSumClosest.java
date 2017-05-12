package com.superluli.arr;

import java.util.Arrays;

/**
 * Note : 3 sum to 0, the solution set must not contain duplicate triplets.
 * 
 * @author Lu
 *
 */
public class ThreeSumClosest {

	public static void main(String[] args) {

		System.err.println(new ThreeSumClosest().threeSumClosest(new int[] { 0,
				0, 0 }, 1));
	}

	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);
		int i = 0;

		int minSum3 = Integer.MAX_VALUE;
		int minDiffAbs = Integer.MAX_VALUE;
		while (i < nums.length) {

			int num = nums[i];
			int diff = twoSum(nums, target - num, i + 1, nums.length - 1);

			if (Math.abs(diff) < minDiffAbs) {
				minDiffAbs = Math.abs(diff);
				minSum3 = diff + target;
			}

			if(minSum3 == target){
				return minSum3;
			}
			
			i++;
		}
		return minSum3;
	}

	/*
	 * If not found, return null
	 */
	public int twoSum(int[] nums, int sum, int from, int to) {

		Integer diffAbs = Integer.MAX_VALUE;
		int diff = Integer.MAX_VALUE;

		while (from < to && from < nums.length && to >= 0) {
			int fromVal = nums[from];
			int toVal = nums[to];
			int s = fromVal + toVal;
			if (s == sum) {
				return 0;
			} else if (s < sum) {
				from++;
			} else {
				to--;
			}
			if (Math.abs(s - sum) < diffAbs) {
				diffAbs = Math.abs(s - sum);
				diff = s - sum;
			}
		}
		return diff;
	}
}
