package com.superluli.linkedlist;


public class ListNode {

	public int val;

	public ListNode next;

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {

		ListNode node = this;

		StringBuilder sb = new StringBuilder();

		while (node != null) {

			sb.append(node.val + " -> ");
			node = node.next;
		}

		return sb.toString();
	}
}
