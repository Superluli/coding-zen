package com.superluli.dp.knapsack;

/*
 * 0-1 knapsack : each item can be used only once
 * n items, each with weight wi and value vi, get max value if knapsack's weight limit is wmax 
 */
public class Knapsack {

	public static void main(String[] args) {

		Item[] items = new Item[3];

		items[0] = new Item(1, 2, 2);
		items[1] = new Item(2, 3, 3);
		items[2] = new Item(3, 4, 5);

		System.err.println(zeroOneKnapsack(items, 3));
		System.err.println(twoDimensionsKnapsack(items, 3, 4));
		System.err.println(limitNumOfItemsKnapsack(items, 5, 5));
		
		System.err.println(zeroOneKnapsackWeightMatch(items, 4));
	}

	/*
	 * sum of items weights doesn't have to match wMax dp[i][j] = put first i
	 * items into knapsack with max weight j transition formula : dp[i][j] =
	 * max(dp[i-1][j], dp[i-1][j-wi] + vi) optimization on space (reduce
	 * dimension): dp[j] = max(dp[j], dp[j-wi]+vi) O(n*wMax)
	 */
	public static int zeroOneKnapsack(Item[] items, int wMax) {

		int n = items.length;
		int[] dp = new int[wMax + 1];

		for (int i = 1; i <= n; i++) {
			int w = items[i - 1].weight;
			int v = items[i - 1].value;
			for (int j = wMax; j >= w; j--) {
				dp[j] = Math.max(dp[j], dp[j - w] + v);
			}
		}
		return dp[wMax];
	}

	/*
	 * sum of items weights must match wMax solution : in initialization phase,
	 * just need to put dp[0] to 0, all others to -MAX O(n*wMax)
	 */
	public static int zeroOneKnapsackWeightMatch(Item[] items, int wMax) {

		int n = items.length;
		int[] dp = new int[wMax + 1];
		for (int j = 1; j <= wMax; j++) {
			dp[j] = Integer.MIN_VALUE;
		}

		for (int i = 1; i <= n; i++) {
			int w = items[i - 1].weight;
			int v = items[i - 1].value;
			for (int j = wMax; j >= w; j--) {
				dp[j] = Math.max(dp[j], dp[j - w] + v);
			}
		}
		return dp[wMax];
	}

	/*
	 * each item can be used UNLIMITED times dp[i][j] = put first i items into
	 * knapsack with max weight j transition formula : dp[i][j] =
	 * max(dp[i-1][j], dp[i][j-wi] + vi) optimization on space (reduce
	 * dimension): dp[j] = max(dp[j], dp[j-wi]+vi) O(n*wMax)
	 */
	public static int completeKnapsack(Item[] items, int wMax) {

		int n = items.length;
		int[] dp = new int[wMax + 1];

		for (int i = 1; i <= n; i++) {
			int w = items[i - 1].weight;
			int v = items[i - 1].value;
			for (int j = w; j <= wMax; j++) {
				dp[j] = Math.max(dp[j], dp[j - w] + v);
			}
		}
		return dp[wMax];
	}

	/*
	 * each item i can be used as many as Li times Solution : transfer to 0-1
	 * problem by splitting each item unlimited i to Li 0-1 items
	 * O(sum(Li)*wMax)
	 * 
	 * Optimization : split each item to 1,2,4,8... E.g. L2 = 17, then split
	 * item2 to item2_1 to item2_5 with weight of 1,2,4,8,16 times of original
	 * weight of item2 O(sum(logLi)*wMax)
	 */
	public static int limitedKnapsack(Item[] items, int wMax) {
		// TODO
		return 0;
	}

	/*
	 * there's one additional dimension for the limit, E.g. weight2 dp[i][j][k]
	 * = put first i items into knapsack with max weight1 j and weight2 k
	 * transition formula : dp[i][j][k] = max(dp[i-1][j][k],
	 * dp[i-1][j-w1i][k-w2i] + vi) optimization on space (reduce dimension):
	 * dp[j][k] = max(dp[j][k], dp[j-w1i][k-w2i]+vi) O(n*w1Max*w2Max)
	 */
	public static int twoDimensionsKnapsack(Item[] items, int w1Max, int w2Max) {

		int n = items.length;
		int[][] dp = new int[w1Max + 1][w2Max + 1];

		for (int i = 1; i <= n; i++) {
			int w1 = items[i - 1].weight;
			int w2 = items[i - 1].weight2;
			int v = items[i - 1].value;
			for (int j = w1Max; j >= w1; j--) {
				for (int k = w2Max; k >= w2; k--) {
					dp[j][k] = Math.max(dp[j][k], dp[j - w1][k - w2] + v);
				}
			}
		}
		return dp[w1Max][w2Max];
	}
	
	/*
	 * Combination of 2 dimension knapsack and complete knapsack : treat number as a "weight" of 1 
	 */
	public static int limitNumOfItemsKnapsack(Item[] items, int w1Max, int limitOfItems) {

		int n = items.length;
		for(int i = 0; i < n; i++){
			items[i].weight2 = 1;
		}
		int w2Max = limitOfItems;
		
		int[][] dp = new int[w1Max + 1][w2Max + 1];

		for (int i = 1; i <= n; i++) {
			int w1 = items[i - 1].weight;
			int w2 = items[i - 1].weight2;
			int v = items[i - 1].value;
			for (int j = w1; j <= w1Max; j++) {
				for (int k = w2; k <= w2Max; k++) {
					dp[j][k] = Math.max(dp[j][k], dp[j - w1][k - w2] + v);
				}
			}
		}
		return dp[w1Max][w2Max];
	}
}
