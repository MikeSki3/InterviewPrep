package tutes.util.ds;

public class LinkedListNode<E> {
	private E data;
	private LinkedListNode<E> next;
	
	public LinkedListNode(E data){
		this.data = data;
	}
	
	//sorta messed up, was setNext before
	public LinkedListNode<E> insert(LinkedListNode<E> next){
		LinkedListNode<E> temp = this.next;
		this.next = next;
		if(next == null){
			return null;
		}
		if(next.getNext() == null) {
			return next;
		} else {
//			int count = 0;
			while(next.getNext() != null){
				next = next.getNext();
//				count++;
			}
			return (temp == null) ? next : next.insert(temp);
		}
	}
	
	public void setNext(LinkedListNode<E> next){
		this.next = next;
	}
	
	public LinkedListNode<E> getNext(){
		return next;
	}
	
	@Override
	public String toString() {
		return data + " -> " + next;
	}

	public E getValue(){
		return data;
	}
}
