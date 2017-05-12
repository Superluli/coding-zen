package com.superluli.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Trie {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.add("ab");

		trie.add("abe");
		trie.add("ace");

		System.err.println(trie.isPrefix("aced"));
		
		System.err.println(trie.listAllWords());
	}

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public class TrieNode {

		char val;
		boolean exist;
		List<TrieNode> nodes;

		public TrieNode() {
			nodes = new LinkedList<TrieNode>();
		}

		@Override
		public String toString() {

			StringBuilder sb = new StringBuilder();

			sb.append(val);

			for (TrieNode node : nodes) {
				sb.append(" " + node.toString());
			}

			return sb.toString();
		}
	}

	@Override
	public String toString() {

		return root.toString();
	}

	public void add(String s) {

		TrieNode cursor = root;

		for (char c : s.toCharArray()) {

			boolean nodeFound = false;

			for (TrieNode child : cursor.nodes) {

				if (c == child.val) {
					cursor = child;
					nodeFound = true;
				}
			}

			if (!nodeFound) {
				TrieNode newChild = new TrieNode();
				newChild.val = c;
				cursor.nodes.add(newChild);
				cursor = newChild;
			}

		}
		cursor.exist = true;
	}

	public boolean isPrefix(String s) {

		TrieNode cursor = root;

		for (char c : s.toCharArray()) {

			boolean nodeFound = false;

			for (TrieNode child : cursor.nodes) {

				if (c == child.val) {
					cursor = child;
					nodeFound = true;
				}
			}
			if (!nodeFound) {
				return false;
			}
		}
		return true;
	}

	public boolean exist(String s) {

		TrieNode cursor = root;

		for (char c : s.toCharArray()) {

			boolean nodeFound = false;

			for (TrieNode child : cursor.nodes) {

				if (c == child.val) {
					cursor = child;
					nodeFound = true;
				}
			}
			if (!nodeFound) {
				return false;
			}
		}
		return cursor.exist;
	}

	public List<String> listAllWords(){
		
		List<String> list = new ArrayList<String>();
		listAllWordsHelper("", this.root, list);
		return list;
	}

	public void listAllWordsHelper(String s, TrieNode root, List<String> list){
		
		if(root == null) return;
		
		if(root.exist){
			list.add(s + root.val);
		}
		for(TrieNode node : root.nodes){
			listAllWordsHelper(s + root.val, node, list);
		}
	}
}
