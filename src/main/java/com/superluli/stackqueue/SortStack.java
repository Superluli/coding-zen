package com.superluli.stackqueue;

import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(2);
		stack.push(1);

		System.err.println(stack);

		sortStack(stack);

		System.err.println(stack);
	}

	public static void sortStack(Stack<Integer> stack) {

		Stack<Integer> sorted = new Stack<Integer>();

		while (!stack.isEmpty()) {

			int val = stack.pop();

			if (sorted.isEmpty() || val <= sorted.peek()) {
				sorted.push(val);
			} else {
				while (!sorted.isEmpty() && val > sorted.peek()) {
					stack.push(sorted.pop());
				}
				sorted.push(val);
			}
		}
		
		while (!sorted.isEmpty()) {
			stack.push(sorted.pop());
		}
	}
}
