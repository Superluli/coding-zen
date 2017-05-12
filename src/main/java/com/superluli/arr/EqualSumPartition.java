package com.superluli.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * 
 * Given a non-empty array containing only positive integers, 
 * find if the array can be partitioned into two subsets such that 
 * the sum of elements in both subsets is equal.
 * Example 1:

 *Input: [1, 5, 11, 5]

 *Output: true

 *Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 *Example 2:

 *Input: [1, 2, 3, 5]

 * Output: false
 * 
 *Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class EqualSumPartition {

	public static void main(String[] args) {

		Random RND = new Random();
		int[] nums = new int[400];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = RND.nextInt(100) + 1;
		}

		nums = new int[] { 1,2,1 };

		long t1 = System.currentTimeMillis();
		System.err.println(new EqualSumPartition().canPartition2(nums));
		System.err.println(System.currentTimeMillis() - t1);
	}

	public boolean canPartition(int[] nums) {

		int sum = 0;
		for (int n : nums) {
			sum += n;
		}

		Map<String, Boolean> cache = new HashMap<String, Boolean>();

		return canPartitionHelper(nums, 0, 0, sum, cache);
	}

	public boolean canPartitionHelper(int[] nums, int diff, int from,
			int sumRight, Map<String, Boolean> cache) {

		String key = diff + ":" + from;

		if (cache.containsKey(key)) {
			return cache.get(key);
		}

		boolean r = false;

		if (from == nums.length) {
			r = diff == 0;
		}

		else if (sumRight < Math.abs(diff) || (diff + sumRight) % 2 != 0) {
			r = false;
		}

		else {
			r = canPartitionHelper(nums, diff + nums[from], from + 1, sumRight
					- nums[from], cache)
					|| canPartitionHelper(nums, diff - nums[from], from + 1,
							sumRight - nums[from], cache);
		}
		cache.put(key, r);
		return r;
	}

	/*
	 * assume exists pair of partitions A and B, sumA = sumB, also sumA + sumB =
	 * sum, so sumA = sum/2, problem converted to subset sum to sum/2 DP, p(i,
	 * sum) = p(i+1, sum-nums[i]) || p(i+1, sum);
	 */
	public boolean canPartition2(int[] nums) {

		
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		if (sum % 2 != 0) {
			return false;
		}
		sum /= 2;
		boolean[][] dp = new boolean[nums.length][sum + 1];
		for (int j = 0; j <= sum; j++) {
			dp[nums.length - 1][j] = nums[nums.length - 1] == j;
		}
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = true;
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			for (int j = 1; j <= sum; j++) {
				dp[i][j] = dp[i + 1][j] || dp[i + 1][j - nums[i]];
			}
		}
		for (int i = 0; i < dp.length; i++) {
			System.err.println(Arrays.toString(dp[i]));
		}
		return dp[0][sum];
	}
}
