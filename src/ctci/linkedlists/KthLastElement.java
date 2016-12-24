package ctci.linkedlists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KthLastElement {
	public static void main(String[] args) {
		LinkedList<Integer> data = new LinkedList<>();
		populateList(data);
		int k = 4;
		System.out.println(recursiveFindKthLast(data.iterator(), data.size() - k, 0));
	}

	private static int findKthLast(int k, LinkedList<Integer> data) {
		int listSize = findSize(data);
		if(listSize < k)
			throw new IndexOutOfBoundsException("kth index not within bounds");
		int index = 0;
		for(int curr : data){
			if(listSize - index == k)
				return curr;
			index++;
		}
		return -1;
	}
	
	private static int findSize(LinkedList<Integer> data){
		int size = 0;
		for(int curr : data)
			size++;
		return size;
	}
	
	private static int recursiveFindKthLast(Iterator<Integer> node, int k, int currK){
		if(k == currK)
			return node.next();
		else {
			node.next();
			return recursiveFindKthLast(node, k, ++currK);
		}
	}

	private static void populateList(List<Integer> data) {
		data.add(5);
		data.add(1);
		data.add(7);
		data.add(2);
		data.add(88);
		data.add(3);
		data.add(21);
	}
}
