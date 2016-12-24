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
		return isPalindrome(list.getHead(), list.size(), 1).isPalindrome;
	}

	//need to figure out a better way to get to the middle and then work out from there
	private static PaliResult<Character> isPalindrome(LinkedListNode<Character> curr, int size, int currNode) {
		PaliResult<Character> result = new LinkedListPalindrome().new PaliResult<>();
		int middle = (size % 2 == 0) ? size / 2 : (size / 2) + 1;
		if(currNode == middle){
			return checkMiddle(curr, size);
		} else {
			result = isPalindrome(curr.getNext(), size, ++currNode);
		}
		if(result.isPalindrome && curr.getValue() == result.next.getValue()){
			result.isPalindrome = true;
			result.next = result.next.getNext();
		} else {
			result.isPalindrome = false;
		}
		return result;
	}

	private static PaliResult<Character> checkMiddle(LinkedListNode<Character> curr, int size) {
		PaliResult<Character> result = new LinkedListPalindrome().new PaliResult<>();
		if(size % 2 == 0 && (curr.getValue() == curr.getNext().getValue())){
			result.next = curr.getNext().getNext();
			result.isPalindrome = true;
		} else if(size % 2 != 0) {
			result.next = curr.getNext();
			result.isPalindrome = true;
		} else {
			result.isPalindrome = false;
		}
		result.middle = curr;
		return result;
	}

	private static void populateList(LinkedList<Character> list) {
		list.add('f');
		list.add('e');
		list.add('e');
		list.add('f');
//		list.add('e');
//		list.add('a');
		list.add('a');
	}
	
	class PaliResult<E> {
		LinkedListNode<E> middle;
		LinkedListNode<E> next;
		boolean isPalindrome;
	}
}
