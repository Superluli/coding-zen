package com.superluli.dp;

import java.util.Arrays;
import java.util.List;

/**
 * Given unlimited number of quarters, dimes, nickels and cents, how many ways
 * can N cents be exchanged
 * 
 * @author Lu
 *
 */
public class EightQueens {

	public static void main(String[] args) {
		System.err.println(eightQueens(8));
	}

	public static int eightQueens(int n) {
		int[] board = new int[n];
		Arrays.fill(board, -1);
		return eightQueensHelper(board, 0);
	}

	/*
	 * 0 : chess can put 1 : chess put 2 : chess not allowed
	 */
	public static int eightQueensHelper(int[] board, int layer) {

		if (layer == board.length) {
			System.err.println(Arrays.toString(board));
			return 1;
		}
		int sum = 0;
		for (int j = 0; j < board.length; j++) {
			if (canPlace(board, layer, j)) {
				board[layer] = j;
				sum += eightQueensHelper(board, layer + 1);
				board[layer] = -1;
			}
		}
		return sum;
	}

	private static boolean canPlace(int[] board, int i, int j) {
		// check vertical
		for (int col : board) {
			if (j == col){
				return false;
			}
		}
		
		for(int row = 0; row < board.length; row ++){
			int col = board[row];
			if(col != -1){
				if(j == col) return false;
				if(Math.abs(j - col) == Math.abs(i - row)) return false;
			}
		}
		return true;
	}
}
