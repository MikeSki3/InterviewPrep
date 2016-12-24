package ctci.linkedlists;

import tutes.util.ds.LinkedList;
import tutes.util.ds.LinkedListNode;

public class LinkedListPalindrome {
	public static void main(String[] args) {
		LinkedList<Character> list = new LinkedList<>('a');
		populateList(list);
		System.out.println(isPalindrome(list));
	}

	private static boolean isPalindrome(LinkedList<Character> list) {
		return isPalindrome(list.getHead(), list.getHead(), 0, list.size());
	}

	//need to figure out a better way to get to the middle and then work out from there
	private static boolean isPalindrome(LinkedListNode<Character> prev, LinkedListNode<Character> next, int currIndex, int size) {
		int middle = size / 2;
		if(currIndex == middle){
			if(size % 2 != 0){
				
			}
		} else {
			return isPalindrome(prev.getNext(), next.getNext(), ++currIndex, size);
		}
		return false;
	}

	private static void populateList(LinkedList<Character> list) {
		list.add('f');
		list.add('e');
		list.add('f');
		list.add('a');
	}
}
