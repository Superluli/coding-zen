package com.superluli.strings;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {

		// printFullCombinations(3);
		System.err.println(printCombinations(3, 2));
		printAllCombinations(3);
		printAllCombinations2(new char[]{'a', 'b', 'c'});
	}

	/*
	 * full combinations, Given two integers n and k, return all possible
	 * combinations of k numbers out of 1 ... n E.g. n = 3, k = 2 return [1,2],
	 * [1,3], [2,3]
	 */
	public static List<List<Integer>> printCombinations(int n, int k) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		printCombinations(n, k, list, new ArrayList<Integer>(), 1);
		return list;
	}

	public static void printCombinations(int n, int k,
			List<List<Integer>> list, List<Integer> tempList, int from) {

		if (k == 0) {
			list.add(new ArrayList<Integer>(tempList));
			return;
		}

		for (int i = from; i <= n; i++) {
			tempList.add(i);
			printCombinations(n, k - 1, list, tempList, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	/*
	 * all combinations, given [a, b, c], return a, b, c, ab, ac, bc, abc
	 */
	public static void printAllCombinations(int n) {

		for (int k = 1; k <= n; k++) {
			System.err.println(printCombinations(n, k));
		}
	}

	/*
	 * all combinations 2
	 * 
	 * print out
	 * 
	 * (a),(b),(c),(d),(e)........(z)
	 * 
	 * (a,b),(a,c),(a,d),(a,e)......(a,z),(b,c),(b,d).....(b,z),(c,d).....(y,z)
	 * 
	 * (a,b,c),(a,b,d)....(a,b,z),(a,c,d)....(x,y,z)
	 * 
	 * ...
	 * 
	 * (a,b,c,d,.....x,y,z)
	 */
	public static void printAllCombinations2(char[] arr) {

		for (int i = 1; i <= arr.length; i++) {
			
			printAllCombinations2(arr, i, 0, 0, new StringBuilder("("));
			System.err.println();
		}
	}

	public static void printAllCombinations2(char[] arr, int n, int nFound, int from, StringBuilder prefix) {
		
		if(nFound == n){
			prefix.append(')');
			System.err.print(prefix.toString());
			System.err.print(',');
			prefix.deleteCharAt(nFound+1);
			return;
		}
		
		for(int i = from; i < arr.length; i++){
			prefix.append(arr[i]);
			printAllCombinations2(arr, n, nFound+1, i+1, prefix);
			prefix.deleteCharAt(nFound+1);
		}
	}
}




