package tutes.util.ds;

public class LinkedList<E> {
	private LinkedListNode<E> head;
	private LinkedListNode<E> tail;
	private int size;
	
	public LinkedList(E data){
		head = new LinkedListNode<>(data);
		tail = head;
		size = 1;
	}
	
	public LinkedListNode<E> getHead(){
		return head;
	}
	
	public void add(E data){
		LinkedListNode<E> temp = new LinkedListNode<>(data);
		tail = tail.setNext(temp);
	}
	
	//Eff this stuff
//	public void insert(LinkedListNode<E> node, int index){
//		if(index == size){
//			add(node);
//		} else if(index > size) {
//			throw new IndexOutOfBoundsException();
//		} else {
//			LinkedListNode<E> curr = head;
//			index--;
//			while(index > 0){
//				curr = curr.getNext();
//				index--;
//			}
//			size += curr.setNext(node);
//		}
//	}
	
	public void add(LinkedListNode<E> node) {
		tail = tail.setNext(node);
	}

	public int size(){
		int size = 0;
		LinkedListNode<E> curr = this.head;
		while(curr != null){
			size++;
			curr = curr.getNext();
		}
		return size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		LinkedListNode<E> temp = head;
		while(temp != null){
			sb.append(temp.getValue());
			sb.append(" ");
			temp = temp.getNext();
		}
		return sb.toString();
	}
	
	
}
