package tutes;

import java.util.Scanner;
import java.util.Stack;

public class Queues {

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}
}

class MyQueue<T> {
	
	private Stack<T> revQueue;
	private Stack<T> realQueue;
	public MyQueue(){
		revQueue = new Stack<>();
		realQueue = new Stack<>();
	}
	
	private void populateRevQueue(){
		while(realQueue.size() > 0){
			revQueue.push(realQueue.pop());
		}
	}
	
	private void populateRealQueue(){
		while(revQueue.size() > 0){
			realQueue.push(revQueue.pop());
		}
	}
	
	public void enqueue(T arg){
		populateRevQueue();
		realQueue.push(arg);
		populateRealQueue();
	}
	
	public T dequeue(){
		return realQueue.pop();
	}
	
	public T peek(){
		T result = realQueue.pop();
		realQueue.push(result);
		return result;
	}
}
