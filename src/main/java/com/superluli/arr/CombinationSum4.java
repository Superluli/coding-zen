package com.superluli.arr;

import java.util.Arrays;

public class CombinationSum4 {

	public static void main(String[] args) {
		
		String s = "123";
		
		String key = 1 + ":" + 2 + ":" + 3 + ":" + false + ":" + 4;
		
		System.err.println(key);
		
		System.err.println(combinationSum4DP(new int[]{2,3,4}, 5));
	}
	
    public int combinationSum4(int[] nums, int target) {
        
        int[] cache = new int[target];
        Arrays.fill(cache, -1);
        return combinationSum4(nums, target, cache);
    }
    
    public int combinationSum4(int[] nums, int target, int[] cache) {
        
        if(target == 0){
            return 1;
        }   
        if(target < 0){
            return 0;
        }
        
        if(cache[target-1] != -1){
            return cache[target-1];
        } 
        int sum = 0;
        
        for(int i : nums){
            sum += combinationSum4(nums, target - i, cache);
        } 
        
        cache[target-1] = sum;
        return sum;
    }
	
	public static int combinationSum4DP(int[] nums, int target) {

		int[] dp = new int[target+1];
		dp[0] = 1;
		for(int i = 1; i < dp.length; i++){
			for(int j = 0; j < nums.length; j++){
				if(nums[j] <= i){
					dp[i] += dp[i-nums[j]];	
				}
			}
		}
		return dp[target];
	}
}
