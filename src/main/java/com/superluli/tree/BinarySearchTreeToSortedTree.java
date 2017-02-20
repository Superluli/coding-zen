package com.superluli.tree;


public class BinarySearchTreeToSortedTree {

	public static void main(String[] args) {

		TreeNode root1 = new TreeNode(1);
		TreeNode expected1 = new TreeNode(1);
		System.out.println(binarySearchTreeToSortedTree(root1)
				.equals(expected1));
		
		TreeNode root2 = new TreeNode(2, new TreeNode(1), null);
		TreeNode expected2 = new TreeNode(1, null, new TreeNode(2));
		System.out.println(binarySearchTreeToSortedTree(root2)
				.equals(expected2));

		TreeNode root3 = new TreeNode(1, null, new TreeNode(2));
		TreeNode expected3 = new TreeNode(1, null, new TreeNode(2));
		System.out.println(binarySearchTreeToSortedTree(root3)
				.equals(expected3));

		TreeNode root4 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		TreeNode expected4 = new TreeNode(1, null, new TreeNode(2, null,
				new TreeNode(3)));
		System.out.println(binarySearchTreeToSortedTree(root4)
				.equals(expected4));

		int size = 7000;

		TreeNode root5 = new TreeNode(size);
		TreeNode node = root5;
		for (int i = size-1; i > 0; i--) {
			node.left = new TreeNode(i);
			node = node.left;
		}

		TreeNode expected5 = new TreeNode(1);
		node = expected5;
		for (int i = 2; i <= size; i++) {
			node.right = new TreeNode(i);
			node = node.right;
		}
		
		System.out.println(binarySearchTreeToSortedTree(root5)
				.equals(expected5));
	}

	public static TreeNode binarySearchTreeToSortedTree(TreeNode root) {

		// find most-left tree node, set as newRoot to return
		TreeNode newRoot = root;
		while (newRoot.left != null) {
			newRoot = newRoot.left;
		}

		flatten(root);

		// return new root
		return newRoot;
	}

	public static void flatten(TreeNode root) {

		// if has left tree, flatten left, flattenLeft.right = root
		if (root.left != null) {
			flattenLeft(root.left).right = root;
			root.left = null;
		}

		// if has right tree, flatten right, root.right = flattenRight
		if (root.right != null) {
			root.right = flattenRight(root.right);
		}
	}

	public static TreeNode flattenLeft(TreeNode root) {

		// flatten tree, return most right child
		flatten(root);
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}

	public static TreeNode flattenRight(TreeNode root) {

		// flatten tree, return root
		return binarySearchTreeToSortedTree(root);
	}
}
