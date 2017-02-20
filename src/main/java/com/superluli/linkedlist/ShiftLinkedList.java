package com.superluli.linkedlist;


public class ShiftLinkedList {

	public static void main(String[] args) {

		System.err.println(shiftLinkedList(new LinkedListNode(1,
				new LinkedListNode(2, new LinkedListNode(3, new LinkedListNode(
						4, null)))), 2));
	}

	/*
	 * 0 -> 1
	 */

	public static LinkedListNode shiftLinkedList(LinkedListNode head, int k) {

		if (head == null) {
			return null;
		}

		int len = 1;
		LinkedListNode cursor = head;
		
		while (cursor.next != null) {
			len ++;
			cursor = cursor.next;
		}
		
		LinkedListNode tail = cursor;
		k %= len;

		if (k == 0) {
			return head;
		}
		
		cursor = head;
		LinkedListNode newHead = head;
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
