package com.superluli.linkedlist;


public class ShiftLinkedList {

	public static void main(String[] args) {

		System.err.println(shiftLinkedList(new ListNode(1,
				new ListNode(2, new ListNode(3, new ListNode(
						4, null)))), 2));
	}

	/*
	 * 0 -> 1
	 */

	public static ListNode shiftLinkedList(ListNode head, int k) {

		if (head == null) {
			return null;
		}

		int len = 1;
		ListNode cursor = head;
		
		while (cursor.next != null) {
			len ++;
			cursor = cursor.next;
		}
		
		ListNode tail = cursor;
		k %= len;

		if (k == 0) {
			return head;
		}
		
		cursor = head;
		ListNode newHead = head;
		int shift = 0;
		
		// find len and tail
		while (cursor.next != null) {
			if (shift == k - 1) {
				newHead = cursor.next;
				cursor.next = null;
				break;
			} else {
				cursor = cursor.next;
			}
			shift++;
		}

		tail.next = head;

		return newHead;
	}
}
