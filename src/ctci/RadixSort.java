package ctci.sortingandsearching;

import java.util.ArrayList;
import java.util.LinkedList;

public class RadixSort {
	private static int max;

	public static void sort(int[] arr) {
		max = arr[0];
		int numIndex = 100;
		ArrayList<LinkedList<Integer>> groups = new ArrayList<>(10);
		fillGroups(groups, arr);
		while (max * 10 > numIndex) {
			for (int j = 0; j < groups.size(); j++) {
				distributeNums(groups.get(j), groups, numIndex);
			}
			numIndex *= 10;
		}
		refillArray(groups, arr);
	}

	private static void refillArray(ArrayList<LinkedList<Integer>> groups, int[] arr) {
		int currI = 0;
		for (LinkedList<Integer> ll : groups) {
			if (ll != null) {
				for (Integer curr : ll) {
					arr[currI] = curr;
					currI++;
				}
			}
		}
	}

	private static void distributeNums(LinkedList<Integer> linkedList, ArrayList<LinkedList<Integer>> groups,
			int numIndex) {
		if (linkedList != null) {
			for (int i = 0; i < linkedList.size(); i++) {
				int curr = linkedList.get(i);
				if (curr * 10 > numIndex) {
					linkedList.remove(i);
					int stripped = stripNumber(numIndex, curr);
					addToGroups(stripped, groups, curr);
				}
			}
		}
	}

	private static void addToGroups(int strippedNum, ArrayList<LinkedList<Integer>> groups, int curr) {
//		if (groups.get(strippedNum) == null) {
//			groups.add(strippedNum, new LinkedList<>());
//			groups.get(strippedNum).add(curr);
//		} else {
			groups.get(strippedNum).add(curr);
//		}
	}

	private static void fillGroups(ArrayList<LinkedList<Integer>> groups, int[] arr) {
		int i = 0;
		for(int j = 0; j < 10; j++){
			groups.add(new LinkedList<>());
		}
		for (int j = 0; j < arr.length; j++) {
			int curr = arr[j];
			max = Math.max(max, curr);
			int strippedNum = stripNumber(i, curr);
			addToGroups(strippedNum, groups, curr);
		}
	}

	public static int stripNumber(int i, int curr) {
		int tens = 10;
		for (int j = tens; j < i; j *= 10) {
			tens *= 10;
		}
		double stripped = curr % tens;
		double diff = stripped % (tens / 10);
		stripped = stripped - diff;
		stripped = stripped * (1.0 / (tens / 10));

		return (int) stripped;
	}
}
