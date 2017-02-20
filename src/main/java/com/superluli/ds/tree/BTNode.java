package com.superluli.ds.tree;

public class BTNode {

	int val;

	public BTNode(int val){
		this.val = val;
	}

	private BTNode left;
	private BTNode right;

	public BTNode getLeft() {
		return left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public BTNode getRight() {
		return right;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
}
