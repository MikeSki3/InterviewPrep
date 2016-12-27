package ctci.stacksandqueues.test;

import java.util.Random;

import ctci.stacksandqueues.MinStack;

public class MinStackTest {

	static int size = 5;

	public static void main(String[] args) {
		MinStack stack = new MinStack(size);
		populateStack(stack);
		System.out.println(stack);
		try {
			System.out.println(stack.min());
			System.out.println(stack.pop());
			System.out.println(stack);
			System.out.println(stack.min());
			System.out.println(stack.pop());
			System.out.println(stack);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void populateStack(MinStack stack) {
		Random rand = new Random();
		try {
			stack.push(1);
			for (int i = 1; i < size; i++) {
				stack.push(rand.nextInt(1000));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
