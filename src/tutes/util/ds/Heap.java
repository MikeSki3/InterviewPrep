package tutes.util.ds;

public class Heap {
	private double[] heap;
	private int size;
	private boolean isMin;

	public Heap(boolean isMin, int size) {
		this.size = 0;
		this.isMin = isMin;
		this.heap = new double[size];
	}
	
	public double pop(){
		double result = heap[0];
		heap[0] = heap[size - 1];
		size--;
		heapifyDown();
		return result;
	}
	
	public double peek(){
		return heap[0];
	}

	public void heapifyDown() {
		int nodeIndex = 0;
		int index = getLeftChildIndex(nodeIndex);
		boolean notHeaped = true;
		while (notHeaped && index < size) {
			if (index < size) {
				if ((index + 1) < size) {
					if(isMin)
						index = (heap[index] < heap[index + 1]) ? index : index + 1;
					else 
						index = (heap[index] > heap[index + 1]) ? index : index + 1;
				}
			}
			if ((heap[nodeIndex] > heap[index] && isMin) ||
				 heap[nodeIndex] < heap[index] && !isMin) {
				swapNodes(nodeIndex, index);
			} else {
				notHeaped = false;
			}
			nodeIndex = index;
			index = getLeftChildIndex(nodeIndex);
		}
	}

	public void heapifyUp() {
		int nodeIndex = size - 1;
		int parentIndex = getParent(nodeIndex);
		boolean notHeaped = true;
		while (notHeaped && parentIndex >= 0) {
			if ((heap[nodeIndex] < heap[parentIndex] && isMin) ||
				(heap[nodeIndex] > heap[parentIndex] && !isMin)) {
				swapNodes(nodeIndex, parentIndex);
			} else {
				notHeaped = false;
			}
			nodeIndex = parentIndex;
			parentIndex = getParent(nodeIndex);
		}
	}
	
	public void addToHeap(double newValue) {
		size++;
		heap[size - 1] = newValue;
		if (size > 1)
			heapifyUp();
	}

	public void swapNodes(int nodeIndex, int parentIndex) {
		double temp = heap[nodeIndex];
		heap[nodeIndex] = heap[parentIndex];
		heap[parentIndex] = temp;
	}

	public int getLeftChildIndex(int parent) {
		return parent * 2 + 1;
	}

	public int getRightChildIndex(int parent) {
		return parent * 2 + 2;
	}

	public int getParent(int child) {
		if (child % 2 == 0)
			return (child - 2) / 2;
		else
			return (child - 1) / 2;
	}
	
	public int getSize(){
		return size;
	}
}
