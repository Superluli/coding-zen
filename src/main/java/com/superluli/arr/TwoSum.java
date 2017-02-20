package com.superluli.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3};
		
		System.err.println(Arrays.toString(twoSum(arr, 5)));
	}

	public static int[] twoSum(int[] nums, int target) {
		
		int[] result = new int[2];
		
		int len = nums.length;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(len);
		
		for (int i = 0; i < len; i++) {
			
			int t = nums[i];
			
			if(map.containsKey(nums[i])){
				result[0] = map.get(t);
				result[1] = i;
				break;
			}
			else{
				map.put(target - t, i);
			}
		}
		return result;
	}
}
