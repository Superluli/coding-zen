package com.superluli.arr;

import java.util.Arrays;

/**
 * Rotate a matrix N*N 90' in clock wise
 * 
 * @author Lu
 *
 */
public class RotateMatrix {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] matrix2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };

		rotate(matrix);
		rotate(matrix2);

		for (int[] row : matrix)
			System.err.println(Arrays.toString(row));
		
		for (int[] row : matrix2)
			System.err.println(Arrays.toString(row));
	}

	public static void rotate(int[][] matrix) {

		int len = matrix.length;

		for (int i = 0; i < len / 2; i++) {

			for (int j = i; j < len - i - 1; j++) {

				int temp = matrix[i][j];
				matrix[i][j] = matrix[len - j - 1][i];
				matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
				matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
				matrix[j][len - i - 1] = temp;
			}
		}
	}
}
