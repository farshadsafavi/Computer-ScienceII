
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;




public class BasicDoubleLinkedList<T> implements Iterable<T>{
	protected Node<T> tail;
	protected Node<T> head;
	protected int size;
	
	public BasicDoubleLinkedList(){
		tail = null;
		head = null;
		size = 0;
	}
	
	public BasicDoubleLinkedList<T> addToEnd(T newElement) {
		Node<T> newNode= new Node<T>(newElement, null, null);
		if (head == null){
			head = newNode;
			tail = newNode;
		} else{
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
		size++;
		return this;
	}

	public int getSize() {
		return size;
	}

	public BasicDoubleLinkedList<T> addToFront(T newElement) {
		Node<T> newNode= new Node<T>(newElement, null, null);
		if (head == null){
			head = newNode;
			tail = newNode;
		} else{
			newNode.next= head;
			head.previous = newNode;
			head = newNode;
		}
		size++;
		return this;
	}

	public ArrayList<T> toArrayList() {
		Node<T> c = head;
		ArrayList<T> arr = new ArrayList<T>();
		while(c != null){
			arr.add(c.data);
			c = c.next;
		}
		return arr;
	}

	public T getFirst() {
		return (T) head.data;
	}

	public T getLast() {
		return (T) tail.data;
	}

	public BasicDoubleLinkedList<T> remove(T a, Comparator comparator) {
		Node<T> c = head;
		while (c != null){
			if (comparator.compare(a, c.data) == 0){
				break;
			}
			c = c.next;
		}
		if( c == head){
			head = head.next;
		}else if(c == tail){
			tail.previous.next = null;
			tail = tail.previous;
		}else{
			c.previous.next = c.next;
			c.next.previous = c.previous;
		}
		return this;
		
	}

	public T retrieveFirstElement() {
		if (head == tail){
			Node<T> temp = head;
			head = tail = null;
			return (T) temp.data;
		} else{
			Node<T> temp = head;
			head = head.next;
			return (T) temp.data;
		}
	}

	public T retrieveLastElement() {
		if (head == tail){
			Node temp = head;
			head = tail = null;
			return (T) temp.data;
		} else{
			Node temp = tail;
			tail = tail.previous;
			return (T) temp.data;
		}
	}

	
	public void print_backward() {
		Node c = tail;
		while(c != head){
			System.out.println(c.data.toString());
			c = c.previous;
		}
		System.out.println(c.data.toString());
	}
	
	public void print_forward() {
		Node<T> c = head;
		while(c != tail){
			System.out.println(c.data.toString());
			c = c.next;
		}
		System.out.println(c.data.toString());
	}
	
	class Node<T>{
		T data;
		Node<T> next;
		Node<T> previous;
		
		public Node(T data, Node<T> next, Node<T> previous){
			this.data = data;
			this.next = next;
			this.previous = previous;
		}
	}

	@Override
	public ListIterator<T> iterator() {
		return new MyLinkedListIterator();
	}
	
	private class MyLinkedListIterator implements ListIterator<T>{
		private Node<T> c = head;
		private Node<T> p = null;
		private Node<T> pointer;
		
		private MyLinkedListIterator(){
			pointer = new Node<T>(null, c, p);
			
		}
		
		@Override
		public void add(T arg0) {
			
		}

		@Override
		public boolean hasNext() {
			return pointer.next != null;
		}

		@Override
		public boolean hasPrevious() {
			return pointer.previous != null;
		}

		@Override
		public T next() throws NoSuchElementException{
			if (!hasNext()) throw new NoSuchElementException();
			T res = pointer.next.data;
			if (c == head){
				c = c.next;
				p = head;
			} else{
				p = c;
				c = c.next;
			}
			pointer.next = c;
			pointer.previous = p;
			return res;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public T previous() throws NoSuchElementException{
			if (!hasPrevious()) throw new NoSuchElementException();
			T res = pointer.previous.data;
			c = p;
			p = p.previous;
			pointer.next = c;
			pointer.previous = p;
			return res;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T arg0) throws UnsupportedOperationException{
			return;
		}
			
		
		
	}

	
	
	

	

}
