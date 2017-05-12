package com.superluli.tree;

public class LowestCommonsAncestor {

	public static void main(String[] args) {

		TreeNode root = TreeNode.fromTreeString("1,2,3");
		System.err.println(LCA(root, 1,2));
		System.err.println(LCA(root, 1,3));
		System.err.println(LCA(root, 2,3));
		root = TreeNode.fromTreeString("1,2,3,4,5,#,#,#,#,6");
		System.err.println(LCA(root, 3,6));
	}

	public static TreeNode LCA(TreeNode root, int x, int y) {
		
		if(root == null) return null;
		if(root.val == x || root.val == y ) return root;
		TreeNode left = LCA(root.left, x, y);
		TreeNode right = LCA(root.right, x, y);
		if(left != null && right != null) return root;
		return left != null ? left : right;
	}
}
