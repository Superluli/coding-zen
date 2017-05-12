package com.superluli.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int[] arr = { 1, 9, 8, 6, 5, 2, 8, 2, 6, 8, 2, 2, 3 };
		
		System.err.println(Arrays.toString(twoSum(arr, 11)));
		System.err.println(Arrays.toString(twoSum2(arr, 11)));
	}

	public static int[] twoSum(int[] nums, int target) {

		int[] result = new int[2];

		int len = nums.length;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>(len);

		for (int i = 0; i < len; i++) {

			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
				break;
			} else {
				map.put(nums[i], i);
			}
		}
		return result;
	}

	/*
	 * binary search
	 */
	public static int[] twoSum2(int[] nums, int target) {

		int[] result = new int[2];

		Arrays.sort(nums);
		
		int i = 0, j = nums.length-1;
		
		while(i < j){
			int sum = nums[i] + nums[j];
			if(sum > target){
				j--;
			}
			else if(sum < target){
				i++;
			}
			else{
				result[0] = i;
				result[1] = j;
				break;
			}
		}
		
		return result;
	}
}
