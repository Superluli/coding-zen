package com.superluli.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of non-negative numbers and a target integer k, write a function
 * to check if the array has a continuous subarray of size at least 2 that sums
 * up to the multiple of k, that is, sums up to n*k where n is also an integer.
 * 
 * Input: [23, 2, 4, 6, 7], k=6 Output: True Explanation: Because [2, 4] is a
 * continuous subarray of size 2 and sums up to 6.
 * 
 * Input: [23, 2, 6, 4, 7], k=6 Output: True Explanation: Because [23, 2, 6, 4,
 * 7] is an continuous subarray of size 5 and sums up to 42.
 * 
 *
 */
public class SubarraySum {

	public static void main(String[] args) {

		int[] nums = {3, 2, 7};
		System.err.println(new SubarraySum().checkSubarraySum2(nums, 3));
	}

	/**
	 * We iterate through the input array exactly once, keeping track of the
	 * running sum mod k of the elements in the process. If we find that a
	 * running sum value at index j has been previously seen before in some
	 * earlier index i in the array, then we know that the sub-array (i,j]
	 * contains a desired sum.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean checkSubarraySum2(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		
		int runningSum = 0;
		for (int i = 0; i < nums.length; i++) {
			runningSum += nums[i];
			if (k != 0)
				runningSum %= k;
			Integer prev = map.get(runningSum);
			if (prev != null) {
				if (i - prev > 1) {
					System.err.println(Arrays.toString(Arrays.copyOfRange(nums,
							prev + 1, i + 1)));
					return true;
				}
			} else
				map.put(runningSum, i);
		}
		return false;
	}

	public boolean checkSubarraySum(int[] nums, int k) {
		if (k == 0)
			return false;
		return checkSubarraySumHelper(nums, 0, k, 0, false, 0,
				new HashMap<String, Integer>());
	}

	public boolean checkSubarraySumHelper(int[] nums, int sum, int k, int from,
			boolean started, int n, Map<String, Integer> cache) {

		String key = sum + ":" + k + ":" + from + ":" + started + ":" + n;

		if (cache.containsKey(key)) {
			return cache.get(key) == 1;
		}

		// termination check
		if (sum % k == 0 && n > 1) {
			return true;
		}

		if (from == nums.length) {
			return false;
		}

		boolean r = checkSubarraySumHelper(nums, sum + nums[from], k, from + 1,
				true, n + 1, cache);

		// if not started, may skip nums[from]
		if (!started) {
			r |= checkSubarraySumHelper(nums, sum, k, from + 1, false, 0, cache);
		}

		int v = r ? 1 : 0;

		cache.put(key, v);

		return r;
	}
}
