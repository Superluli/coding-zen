package com.superluli.linkedlist;


public class ReverseLinkedList {

	public static void main(String[] args) {

		System.err.println(reverseLinkedList1(null));
		System.err.println(reverseLinkedList1(new LinkedListNode(1, null)));
		System.err.println(reverseLinkedList1(new LinkedListNode(1,
				new LinkedListNode(2, new LinkedListNode(3, null)))));
		System.err
				.println(reverseLinkedList1(new LinkedListNode(1,
						new LinkedListNode(2, new LinkedListNode(3,
								new LinkedListNode(4, new LinkedListNode(5,
										new LinkedListNode(6, null))))))));

		System.err.println(reverseLinkedList2(null));
		System.err.println(reverseLinkedList2(new LinkedListNode(1, null)));
		System.err.println(reverseLinkedList2(new LinkedListNode(1,
				new LinkedListNode(2, new LinkedListNode(3, null)))));
		System.err
				.println(reverseLinkedList2(new LinkedListNode(1,
						new LinkedListNode(2, new LinkedListNode(3,
								new LinkedListNode(4, new LinkedListNode(5,
										new LinkedListNode(6, null))))))));
	}
	
	
	public static LinkedListNode reverseLinkedList1(LinkedListNode head) {

		if(head == null || head.next == null){
			return head;
		}
		
		LinkedListNode next = head.next;
		LinkedListNode newHead = reverseLinkedList1(next);
		next.next = head;		
		head.next = null;
		
		return newHead;
	}
	
	public static LinkedListNode reverseLinkedList2(LinkedListNode head) {

		LinkedListNode current = head;
		LinkedListNode pre = null, next = null;
		
		while (current != null) {
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		
		return pre;
	}
}
