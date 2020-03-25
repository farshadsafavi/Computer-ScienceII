import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	private Comparator<T> comparator;

	
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		super.tail = null;
		super.head = null;
		super.size = 0;
		this.comparator = comparator;
	}

	
	public SortedDoubleLinkedList<T> add(T newElement) {
		Node<T> c = head;
		Node<T> newNode = new Node<T>(newElement, null, null);
		if(c== null){
			head = tail = newNode;
		}else{
			while(c != null){
				System.out.println(comparator.compare(newElement, c.data) );
				if (comparator.compare(newElement, c.data) < 0){
					break;
				}
				c = c.next;
			}
			if(c == head){
				newNode.next = head;
				head.previous = newNode;
				head = newNode;
			} else if(c == null){
				newNode.previous = tail;
				tail.next = newNode;
				tail = newNode;
			}else{
				newNode.previous = c.previous;
				c.previous.next = newNode;
				c.previous = newNode;
				newNode.next = c;
			}
		}
		super.size++;
		return this;
	}
	
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data){
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
	
	@Override
	public ListIterator<T> iterator() {
		return super.iterator();
	}
	
	
	public SortedDoubleLinkedList<T> remove(T a){
		return (SortedDoubleLinkedList<T>) super.remove(a, comparator);
		
	}
	

}
