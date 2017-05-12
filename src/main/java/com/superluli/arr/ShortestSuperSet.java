package com.superluli.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Given array of words N, find shortest sub-array N' that contains all key
 * words in M
 * 
 * @author Lu
 *
 */
public class ShortestSuperSet {

	public static void main(String[] args) {
//
//		String[] arr = { "C", "X", "X", "X", "X", "X", "X", "X", "X", "B", "A",
//				"X", "X", "X", "X", "X", "B", "X", "X", "C", "A", "X", "X",
//				"X", "X", "X", "X", "X", "B", "X", "C" };
		
		Random RND = new Random();
		String[] arr = new String[100000];
		Arrays.fill(arr, "X");
		for(int i = 0; i < 5; i++){
			arr[RND.nextInt(arr.length)] = "A";
			arr[RND.nextInt(arr.length)] = "B";
			arr[RND.nextInt(arr.length)] = "C";
		}

		System.err.println(Arrays.toString(arr));
		
		Set<String> keywords = new HashSet<String>(Arrays.asList("A", "B", "C"));

		long t1 = System.currentTimeMillis();
		
		System.err.println(shortestSuperSet(arr, keywords));
		
		long t2 = System.currentTimeMillis();
		
		System.err.println(shortestSuperSet2(arr, keywords));
		long t3 = System.currentTimeMillis();
		
		System.err.println(t2 - t1);
		System.err.println(t3 - t2);
	}

	/*
	 * Brute force, find shortes subarray starting from each position in arr,
	 * and compare. O(N^2)
	 */
	public static List<String> shortestSuperSet(String[] arr,
			Set<String> keywords) {

		int left = 0, len = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			Set<String> tempKeywords = new HashSet<String>(keywords);
			int j = i;
			for (; j < arr.length; j++) {
				String s = arr[j];
				tempKeywords.remove(s);
				if (tempKeywords.isEmpty())
					break;
			}
			if (tempKeywords.isEmpty()) {
				if (j - i + 1 < len) {
					len = j - i + 1;
					left = i;
				}
			}
		}
		List<String> list = new ArrayList<String>();
		for (int k = left; k < left + len; k++) {
			list.add(arr[k]);
		}
		return list;
	}

	/*
	 * extract each keyword and it's index out of array N first O(n)
	 */

	public static class Pair {
		String val;
		int index;

		public Pair(String val, int index) {
			super();
			this.val = val;
			this.index = index;
		}

	}

	public static List<String> shortestSuperSet2(String[] arr,
			Set<String> keywords) {

		List<Pair> words = new ArrayList<ShortestSuperSet.Pair>();
		for (int i = 0; i < arr.length; i++) {
			if (keywords.contains(arr[i])) {
				words.add(new Pair(arr[i], i));
			}
		}
		int start = 0, len = Integer.MAX_VALUE;
		Set<String> tempKeywords = new HashSet<String>(keywords);
		Map<String, Integer> counts = new HashMap<String, Integer>();
		int left = 0, right = 0;
		for (; right < words.size(); right++) {
			String word = words.get(right).val;
			Integer count = counts.get(word);
			count = count == null ? 1 : count + 1;
			counts.put(word, count);
			tempKeywords.remove(word);
			if (tempKeywords.isEmpty())
				break;
		}

		while (left < words.size() && right < words.size()) {
			// try to move left forward, as long as range still contains all key
			// words
			String leftWord = words.get(left).val;
			int leftWordCount = counts.get(leftWord);
			if (leftWordCount > 1) {
				counts.put(leftWord, leftWordCount - 1);
				left++;
				continue;
			}
			// if cannot move forward, this range is a candidate
			else {
				int tempLen = words.get(right).index - words.get(left).index
						+ 1;
				if (tempLen < len) {
					len = tempLen;
					start = words.get(left).index;
				}
			}
			// move right forward
			right++;
			if (right < words.size()) {
				String rightWord = words.get(right).val;
				int rightWordCount = counts.get(rightWord);
				counts.put(rightWord, rightWordCount + 1);
			}
		}

		List<String> list = new ArrayList<String>();
		for (int k = start; k < start + len; k++) {
			list.add(arr[k]);
		}
		return list;
	}
}
