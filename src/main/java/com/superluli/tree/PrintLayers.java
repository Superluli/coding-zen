package com.superluli.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Print layers of a binary tree
 * @author Lu
 *
 */
public class PrintLayers {

	
	public static void main(String[] args) {
		
		System.err.println(printLayersDFS(TreeNode.fromTreeString("1,2,3,4,5")));
		
		System.err.println(printLayersBFS(TreeNode.fromTreeString("1,2,3,4,5")));
	}
	
	/*
	 * DFS, 
	 */
	public static List<List<Integer>> printLayersDFS(TreeNode root){
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		printLayersDFS(root, 0, results);
		return results;
	}
	
	private static void printLayersDFS(TreeNode root, int layer, List<List<Integer>> results){
		
		if(root == null) return;
		
		if(results.size() == layer){
			results.add(new ArrayList<Integer>());
		}
		
		results.get(layer).add(root.val);
		printLayersDFS(root.left, layer+1, results);
		printLayersDFS(root.right, layer+1, results);
	}
	
	/*
	 * BFS, use 2 queues
	 */
	public static List<List<Integer>> printLayersBFS(TreeNode root){
		
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<TreeNode> current = new ArrayList<TreeNode>();
		if(root != null) current.add(root);
		while(!current.isEmpty()){
			
			List<Integer> tempList = new ArrayList<Integer>();
			current.stream().forEach(node -> tempList.add(node.val));
			results.add(tempList);
			List<TreeNode> next = new ArrayList<TreeNode>();
			for(TreeNode node : current){
				if(node.left != null) next.add(node.left);
				if(node.right != null) next.add(node.right);
			}
			current = next;
		}
		
		return results;
	}
}
