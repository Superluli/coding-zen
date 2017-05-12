package com.superluli.tree;

import java.util.LinkedList;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
		super();
	}

	public TreeNode(int val) {
		super();
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		result = prime * result + val;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		if (val != other.val)
			return false;
		return true;
	}

	/**
	 * BFS
	 * 
	 * @return
	 */
	public String toString() {

		StringBuilder sb = new StringBuilder();

		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.addLast(this);

		while (!q.isEmpty()) {
			TreeNode node = q.pollFirst();
			if(node != null){
				sb.append(node.val + ",");
				q.addLast(node.left);
				q.addLast(node.right);	
			}
			else{
				sb.append("#,");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	public static TreeNode fromTreeString(String str){
		if(str == null) return null;
		String[] arr = str.split(",");
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		if(arr.length == 0 || arr[0].equals("#") || arr[0].equals("")) return null;
		TreeNode root = new TreeNode(Integer.valueOf(arr[0])); 
		q.addLast(root);
		int i = 1;
		while(!q.isEmpty() && i < arr.length){
			TreeNode node = q.pollFirst();
			if(!arr[i].equals("#")){
				node.left = new TreeNode(Integer.valueOf(arr[i]));
				q.addLast(node.left);
			}
			i++;
			if(i == arr.length) break;
			if(!arr[i].equals("#")){
				node.right = new TreeNode(Integer.valueOf(arr[i]));
				q.addLast(node.right);
			}
			i++;
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(3)), null);
		String str = node.toString();
		System.err.println(str);
		TreeNode node2 = TreeNode.fromTreeString("");
		System.err.println(node2);
	}
}
