package ctci.linkedlists;

import java.util.Random;

import tutes.util.ds.LinkedList;
import tutes.util.ds.LinkedListNode;

public class Intersection {
	public static void main(String[] args) {
		LinkedList<Integer> listA = new LinkedList<>(89);
		LinkedList<Integer> listB = new LinkedList<>(78);
		populateList(listA, 5);
		populateList(listB, 3);
		intersect(listA, listB, 2);
		System.out.println(intersectionExists(listA, listB));
	}
	
	private static LinkedListNode<Integer> intersectionExists(LinkedList<Integer> listA, LinkedList<Integer> listB) {
		if(listA.size() == listB.size()){
			return findIntersectingNode(listA.getHead(), listB.getHead());
		} else {
			if(listA.size() > listB.size()){
				return findIntersectingNode(moveForwards(listA, listA.size() - listB.size()), listB.getHead());
			} else {
				return findIntersectingNode(listA.getHead(), moveForwards(listB, listB.size() - listA.size()));
			}
		}
		
//		return null;
	}

	private static LinkedListNode<Integer> moveForwards(LinkedList<Integer> list, int inc) {
		LinkedListNode<Integer> curr = list.getHead();
		for(int i = 0; i < inc; i++){
			curr = curr.getNext();
		}
		return curr;
	}

	private static LinkedListNode<Integer> findIntersectingNode(LinkedListNode<Integer> headA,
			LinkedListNode<Integer> headB) {
		if(headA == headB){
			return headA;
		} else if (headA == null || headB == null) {
			return null;
		} else {
			return findIntersectingNode(headA.getNext(), headB.getNext());
		}
	}

	private static void intersect(LinkedList<Integer> listA, LinkedList<Integer> listB, int intersectPoint) {
		LinkedListNode<Integer> iNode = listA.getHead().getNext();
//		LinkedListNode<Integer> bEnd = listB.getHead();
		for(int i = 1; i < intersectPoint; i++){
			iNode = iNode.getNext();
//			bEnd = bEnd.getNext();
		}
//		bEnd.setNext(iNode);
		listB.add(iNode);
	}

	private static void populateList(LinkedList<Integer> list, int size) {
		Random rand = new Random();
		for(int i = 1; i < size; i++){
			list.add(rand.nextInt(1000));
		}
	}
}
