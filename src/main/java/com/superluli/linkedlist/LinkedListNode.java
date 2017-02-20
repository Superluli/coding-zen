package com.superluli.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedListNode {

	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		for (String temp : a) {
			if ("2".equals(temp)) {
				a.remove(temp);
			}
		}
		
		System.err.println(a);
	}

	public int val;

	public LinkedListNode next;

	public LinkedListNode(int val, LinkedListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {

		LinkedListNode node = this;

		StringBuilder sb = new StringBuilder();

		while (node != null) {

			sb.append(node.val + " -> ");
			node = node.next;
		}

		return sb.toString();
	}
}
