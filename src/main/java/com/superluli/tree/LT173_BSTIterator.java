package com.superluli.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LT173_BSTIterator implements Iterator<TreeNode> {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1),
				new TreeNode(3)), new TreeNode(6, new TreeNode(5),
				new TreeNode(7)));

		LT173_BSTIterator itr = new LT173_BSTIterator(root);

		while (itr.hasNext()) {
			System.err.println(itr.next().val);
		}
	}

	List<TreeNode> nodeList;
	int index;

	public LT173_BSTIterator(TreeNode root) {

		nodeList = new LinkedList<TreeNode>();
		index = 0;
		nodeList = sort(root);
	}

	public List<TreeNode> sort(TreeNode root) {

		LinkedList<TreeNode> list = new LinkedList<TreeNode>();

        if(root == null){
            return list;
        }
		
		if (root.left != null) {
			list.addAll(sort(root.left));
		}
		list.add(root);
		if (root.right != null) {
			list.addAll(sort(root.right));
		}
		return list;
	}

	public boolean hasNext() {
		return index < nodeList.size();
	}

	public TreeNode next() {

		return nodeList.get(index++);
	}
}
