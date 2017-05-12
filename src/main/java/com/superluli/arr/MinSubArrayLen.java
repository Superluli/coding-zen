package com.superluli.arr;

/*
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinSubArrayLen {

	public static void main(String[] args) {

		System.err.println(minSubArrayLen(3, new int[] { 1, 2, 3}));
	}

	public static int minSubArrayLen(int s, int[] nums) {

		int i = 0, j = -1, sum = 0;
		int minLen = nums.length + 1;

		while (j < nums.length - 1) {

			// move j to the right, until sum >= s
			j++;
			sum += nums[j];
			while (j < nums.length - 1 && sum < s) {
				j++;
				sum += nums[j];
			}

			if (j == nums.length - 1 && sum < s) {
				break;
			}

			// move i to the right to keep sum <= s
			while (i < j && sum - nums[i] >= s) {
				sum -= nums[i];
				i++;
			}

			// count and update minLen;
			minLen = Integer.min(minLen, j - i + 1);
		}
		return minLen == nums.length + 1 ? 0 : minLen;
	}
}
