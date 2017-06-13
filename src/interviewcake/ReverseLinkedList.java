package interviewcake;

import java.util.Random;

import tutes.util.ds.LinkedList;
import tutes.util.ds.LinkedListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		LinkedListNode<Integer> data = generateList();
		System.out.println(data);
		System.out.println(reverseList(data));
	}
	
	private static LinkedListNode<Integer> reverseList(LinkedListNode<Integer> data) {
		LinkedListNode<Integer> curr = data, prev = null, next;
		
		while(curr != null){
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static LinkedListNode<Integer> generateList() {
		LinkedList<Integer> result = new LinkedList<Integer>();
		Random rand = new Random();
		int size = 5;
		for(int i = 0; i < size; i++){
			int nextInt = rand.nextInt(100);
			result.add(nextInt);
		}
		return result.getHead();
	}
	
}
