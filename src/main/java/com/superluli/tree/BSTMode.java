package com.superluli.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BSTMode {

	static int maxCount = -1;

	public static void main(String[] args) {

		TreeNode root = TreeNode.fromTreeString("3");
		System.err.println(root);
		System.err.println(Arrays.toString(findMode(root)));
		System.err.println(Arrays.toString(new Solution().findMode(root)));
	}

	public static class Solution {
		
	    Integer prev = null;
	    int count = 1;
	    int max = 0;
	    public int[] findMode(TreeNode root) {
	        if (root == null) return new int[0];
	        
	        List<Integer> list = new ArrayList<>();
	        traverse(root, list);
	        
	        int[] res = new int[list.size()];
	        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
	        return res;
	    }
	    
	    private void traverse(TreeNode root, List<Integer> list) {
	        if (root == null) return;
	        traverse(root.left, list);
	        if (prev != null) {
	            if (root.val == prev)
	                count++;
	            else
	                count = 1;
	        }
	        if (count > max) {
	            max = count;
	            list.clear();
	            list.add(root.val);
	        } else if (count == max) {
	            list.add(root.val);
	        }
	        prev = root.val;
	        traverse(root.right, list);
	    }
	}
	
	public static int[] findMode(TreeNode root) {

		if (root == null)
			return new int[0];

		Map<Integer, Integer> modes = new HashMap<Integer, Integer>();
		findModeHelper(root, modes);
		List<Integer> list = new ArrayList<Integer>();
		int max = Integer.MIN_VALUE;

		for (Map.Entry<Integer, Integer> entry : modes.entrySet()) {
			int val = entry.getKey();
			int count = entry.getValue();
			if (count == max) {
				list.add(val);
			}
			if (count > max) {
				max = count;
				list.clear();
				list.add(val);
			}
		}

		int[] arr = new int[list.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	public static void findModeHelper(TreeNode root, Map<Integer, Integer> modes) {

		if (root == null)
			return;
		findModeHelper(root.left, modes);
		findModeHelper(root.right, modes);
		Integer count = modes.get(root.val);
		if (count != null) {
			modes.put(root.val, count + 1);
		} else {
			modes.put(root.val, 1);
		}
	}
}
