package tutes.util.ds;

public class LinkedListNode<E> {
	private E data;
	private LinkedListNode<E> next;
	
	public LinkedListNode(E data){
		this.data = data;
	}
	
	public LinkedListNode<E> setNext(LinkedListNode<E> next){
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
			return (temp == null) ? next : next.setNext(temp);
		}
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
