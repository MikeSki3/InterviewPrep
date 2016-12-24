package tutes.util.ds;

public class LinkedListNode<E> {
	private E data;
	private LinkedListNode<E> next;
	
	public LinkedListNode(E data){
		this.data = data;
	}
	
	public void setNext(LinkedListNode<E> next){
		this.next = next;
	}
	
	public LinkedListNode<E> getNext(){
		return next;
	}
	
	@Override
	public String toString() {
		return "LinkedListNode [data=" + data + ", next=" + next + "]";
	}

	public E getValue(){
		return data;
	}
}
