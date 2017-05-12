package com.superluli.arr;

import java.util.Arrays;
import java.util.Random;

public class MinPathSum {

	private static final Random RND = new Random();

	public static void main(String[] args) {
		int m = 18, n = 12;
		int[][] grid = new int[m][n];
		for (int[] row : grid) {
			for (int i = 0; i < n; i++) {
				row[i] = RND.nextInt(10);
			}
			System.err.println(Arrays.toString(row));
		}
		
		long t1 = System.currentTimeMillis();
		System.err.println(new MinPathSum().minPathSum(grid));
		System.err.println(System.currentTimeMillis() -t1);
	}

	public int minPathSum(int[][] grid) {

		int[][] cache = new int[grid.length][grid[0].length];
		return minPathSum(grid, 0, 0, cache);
	}

	public int minPathSum(int[][] grid, int i, int j, int[][] cache) {

		int result = 0;
		if (cache[i][j] != 0) {
			return cache[i][j];
		}

		if (i == grid.length - 1 && j == grid[0].length - 1) {
			result = grid[i][j];
		}
		// go either right or down
		else if (i < grid.length - 1 && j < grid[0].length - 1) {
			result = grid[i][j]
					+ Math.min(minPathSum(grid, i + 1, j, cache),
							minPathSum(grid, i, j + 1, cache));
		}
		// go right
		else if (i < grid.length - 1) {
			result = grid[i][j] + minPathSum(grid, i + 1, j, cache);
		} else {
			// go down
			result = grid[i][j] + minPathSum(grid, i, j + 1, cache);
		}
		cache[i][j] = result;
		return result;
	}
}
