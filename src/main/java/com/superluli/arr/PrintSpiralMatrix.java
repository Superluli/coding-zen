package com.superluli.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 123 456 789
 * 
 * => 123698745
 * 
 * @author Lu
 *
 */
public class PrintSpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix1 = { { 1 } };
		int[][] matrix2 = new int[][] { { 1, 2 }, { 3, 4 } };
		int[][] matrix3 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] matrix4 = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		System.err.println(printSpiralMatrix(matrix1));
		System.err.println(printSpiralMatrix(matrix2));
		System.err.println(printSpiralMatrix(matrix3));
		System.err.println(printSpiralMatrix(matrix4));
	}

	public static List<Integer> printSpiralMatrix(int[][] matrix) {

		int len = matrix.length;
		List<Integer> list = new ArrayList<Integer>();

		for (int layer = 0; layer < (len + 1) / 2; layer++) {
			for (int j = layer; j < len - layer - 1; j++)
				list.add(matrix[layer][j]);
			for (int i = layer; i < len - layer - 1; i++)
				list.add(matrix[i][len - layer - 1]);
			for (int j = len - layer - 1; j >= layer + 1; j--)
				list.add(matrix[len - layer - 1][j]);
			for (int i = len - layer - 1; i >= layer + 1; i--)
				list.add(matrix[i][layer]);
			if (len % 2 == 1 && len / 2 == layer)
				list.add(matrix[layer][layer]);
		}
		return list;
	}
}
