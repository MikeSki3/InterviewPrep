package ctci.stacksandqueues;

import java.util.Random;
import java.util.Stack;

public class SortStack {
	static int size;

	public static void main(String[] args) {
		size = 10;
		Stack<Integer> stack = new Stack<>();
		populateStack(stack);
		sort(stack);
		System.out.println(stack);
	}

	private static void sort(Stack<Integer> stack) {
		Stack<Integer> tempStack = new Stack<>();
		for (int currSize = size; currSize > 0; currSize--) {
			int max = getMax(stack, tempStack, currSize);
			reStack(max, stack, tempStack, currSize);
		}
	}

	private static void reStack(int max, Stack<Integer> stack, Stack<Integer> tempStack, int size) {
		stack.push(max);
		for(int i = size; i > 0; i--){
			int curr = tempStack.pop();
			if(curr != max){
				stack.push(curr);
			}
		}
	}

	private static int getMax(Stack<Integer> stack, Stack<Integer> tempStack, int size) {
		int max = stack.peek();
		for(int i = size; i > 0; i--){
			int curr = stack.pop();
			tempStack.push(curr);
			if(curr > max)
				max = curr;
		}
		return max;
	}

	private static void populateStack(Stack<Integer> stack) {
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			stack.push(rand.nextInt(50) + 1);
		}
	}
}
