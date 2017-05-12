package com.superluli.linkedlist;


public class ReverseLinkedList {

	public static void main(String[] args) {

		System.err.println(reverseLinkedList1(null));
		System.err.println(reverseLinkedList1(new ListNode(1, null)));
		System.err.println(reverseLinkedList1(new ListNode(1,
				new ListNode(2, new ListNode(3, null)))));
		System.err
				.println(reverseLinkedList1(new ListNode(1,
						new ListNode(2, new ListNode(3,
								new ListNode(4, new ListNode(5,
										new ListNode(6, null))))))));

		System.err.println(reverseLinkedList2(null));
		System.err.println(reverseLinkedList2(new ListNode(1, null)));
		System.err.println(reverseLinkedList2(new ListNode(1,
				new ListNode(2, new ListNode(3, null)))));
		System.err
				.println(reverseLinkedList2(new ListNode(1,
						new ListNode(2, new ListNode(3,
								new ListNode(4, new ListNode(5,
										new ListNode(6, null))))))));
	}
	
	
	public static ListNode reverseLinkedList1(ListNode head) {

		if(head == null || head.next == null){
			return head;
		}
		
		ListNode next = head.next;
		ListNode newHead = reverseLinkedList1(next);
		next.next = head;		
		head.next = null;
		
		return newHead;
	}
	
	public static ListNode reverseLinkedList2(ListNode head) {

		ListNode current = head;
		ListNode pre = null, next = null;
		
		while (current != null) {
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		
		return pre;
	}
}
