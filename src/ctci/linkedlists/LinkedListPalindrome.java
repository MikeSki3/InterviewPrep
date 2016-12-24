package ctci.linkedlists;

import tutes.util.ds.LinkedList;

public class LinkedListPalindrome {
	public static void main(String[] args) {
		LinkedList<Character> list = new LinkedList<>('a');
		populateList(list);
		
	}

	private static void populateList(LinkedList<Character> list) {
		list.add('f');
		list.add('e');
		list.add('f');
		list.add('a');
	}
}
