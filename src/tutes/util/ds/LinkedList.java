package tutes.util.ds;

public class LinkedList<E> {
	private LinkedListNode<E> head;
	private LinkedListNode<E> tail;
	private int size;
	
	public LinkedList(E data){
		head = new LinkedListNode<>(data);
		tail = head;
		size = 0;
	}
	
	public LinkedListNode<E> getHead(){
		return head;
	}
	
	public void add(E data){
		LinkedListNode<E> temp = new LinkedListNode<>(data);
		tail.setNext(temp);
		tail = temp;
		size++;
	}
	
	public int size(){
		return size;
	}
}
