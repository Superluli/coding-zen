package com.superluli.linkedlist;

import java.util.LinkedList;

public class IsPalindrome {

	public static void main(String[] args) {

		System.err.println(isPalinDrome(new ListNode(1, null)));
		System.err
				.println(isPalinDrome(new ListNode(1, new ListNode(2, null))));
		System.err
				.println(isPalinDrome(new ListNode(1, new ListNode(1, null))));

		System.err.println(isPalinDrome(new ListNode(1, new ListNode(2,
				new ListNode(2, new ListNode(1, null))))));
	}

	public static boolean isPalinDrome(ListNode head) {

		ListNode c1 = head;
		ListNode c2 = head;
		boolean isEven = false;

		while (c2.next != null && c2.next.next != null) {
			c2 = c2.next.next;
			c1 = c1.next;
		}

		if (c2.next != null)
			isEven = true;

		LinkedList<Integer> stack = new LinkedList<Integer>();
		ListNode c = head;
		while (c != null && c != c1) {
			stack.addFirst(c.val);
			c = c.next;
		}
		if (isEven)
			stack.addFirst(c.val);
		c = c1.next;
		while (c != null) {
			if (c.val != stack.pollFirst())
				return false;
			c = c.next;
		}
		return stack.isEmpty();
	}
}
