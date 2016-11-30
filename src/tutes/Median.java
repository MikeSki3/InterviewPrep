package tutes;

import java.util.Scanner;

import tutes.util.ds.Heap;

public class Median {
	static double median;
	static Heap minHeap;
	static Heap maxHeap;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		minHeap = new Heap(true, n);
		maxHeap = new Heap(false, n);
		median = 0.0;
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
			addNewNum(a[a_i]);
			System.out.println(getMedian());
		}
	}

	private static void addNewNum(int newValue) {
		if (newValue > median) {
			minHeap.addToHeap(newValue);
		} else {
			maxHeap.addToHeap(newValue);
		}
		rebalance();
	}

	private static void rebalance() {
		while(Math.abs(minHeap.getSize() - maxHeap.getSize()) > 1){
			if(minHeap.getSize() > maxHeap.getSize()){
				maxHeap.addToHeap(minHeap.pop());
			} else {
				minHeap.addToHeap(maxHeap.pop());
			}
		}
	}

	private static double getMedian() {
		if(minHeap.getSize() == maxHeap.getSize()){
			median = (minHeap.peek() + maxHeap.peek()) / 2;
		} else {
			median = (minHeap.getSize() > maxHeap.getSize()) ? minHeap.peek() : maxHeap.peek();
		}
		
		return median;
	}
}
