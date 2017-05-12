package com.superluli.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BottomTopTraversal {

	public static void main(String[] args) {

	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();

		if (root != null) {
			queue.addLast(root);
			queue.addLast(null);
		}

		List<Integer> tempList = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.pollFirst();
			if (node == null) {
				list.addFirst(new ArrayList(tempList));
				tempList = new ArrayList<Integer>();
				if (queue.isEmpty())
					break;
				else {
					queue.addLast(null);
					continue;
				}
			}
			tempList.add(node.val);
			if (node.left != null)
				queue.addLast(node.left);
			if (node.right != null)
				queue.addLast(node.right);
		}

		return list;
	}
}
