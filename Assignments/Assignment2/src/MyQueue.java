/**
 * 
 * @author Farshad Safavi
 * @param <T>
 */

public class MyQueue<T> implements QueueInterface<T>{
	// There are four fields defined in this class
	private Node head;
	private Node tail;
	private int numberOfEntries;
	private int size;
	
	/**
	 * Constructor MyQueue which get the size and initiate all fields
	 * It implements methods in the Queue Interface and some helper functions to 
	 * facilitate operations.
	 * @param size
	 */
	public MyQueue(int size){
		head = null;
		tail = null;
		this.size = size;
		numberOfEntries = 0;
	}
	
	/**
	 * Default constructor MyQueue() which initiate all the fields
	 * the default size of the queue is 5.
	 */
	public MyQueue(){
		head = null;
		tail = null;
		numberOfEntries = 0;
		size = 5;
	}
	
	/**
	 * Helper function to return number of entries
	 * @return number of entries
	 */
	public int getNumberOfEntries(){
		return numberOfEntries;
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return this.numberOfEntries == 0;
	}
	
	/**
	 * Determines if Queue is full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		return this.numberOfEntries == this.size;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	@Override
	public T dequeue() {
		Node newNode = null;
		if (isEmpty()){
			return null;
		} else{
			newNode = head;
			head = newNode.next;
			numberOfEntries--;
			return newNode.data;
		}
	}

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return this.numberOfEntries;
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean enqueue(T e) {
		if(isFull()){
			return false;
		}else{
			Node newNode = new Node(e, null);
			if (head == null && tail == null){
				head = newNode;
				tail = newNode;
			} else{
				tail.next = newNode;
				tail = newNode;
			}
			this.numberOfEntries++;
			return true;
		}
	}
	
	/**
	 * Returns the elements of the Queue in an array, [0] is front of Queue, [1] is next in Queue, etc.
	 * @return an array of the Object elements in the Queue
	 */
	@Override
	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] array = (T[])new Object[this.numberOfEntries];
		Node cur = head;
		int count = 0;
		while(cur != null){
			System.out.print(cur.data + " ");
			array[count++] = cur.data;
			cur = cur.next;
		}
		System.out.println();
		System.out.println(array.length);
		return array;
	}
	
	/**
	 * print contents of the queue. The method is used for debug purposes.
	 */
	public void print_queue(){
		Node cur = head;
		while(cur != null){
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
	}
	
	/**
	 * 
	 * @author Farshad Safavi
	 * Inner class Node which is used to implement MyQueue
	 */
	class Node{
		T data;
		Node next;
		
		public Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
	}

}
