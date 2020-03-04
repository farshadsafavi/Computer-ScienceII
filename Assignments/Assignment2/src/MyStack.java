/**
 * 
 * @author Farshad Safavi
 * @param <T>
 */

public class MyStack<T> implements StackInterface<T>{
	private Node head; 
	private int numberOfEntries;
	private int size;
	
	/**
	 * Default constructor - uses default as the size of the stack
	 */
	public MyStack(){
		this.head = null;
		this.numberOfEntries = 0;
		this.size = 5;
	}
	
	/**
	 * Constructor takes in an int as the size of the stack
	 * It implements methods in the StackInterface and some helper functions to 
	 * facilitate operations.
	 * @param size
	 */
	public MyStack(int size){
		this.head = null;
		this.numberOfEntries = 0;
		this.size = size;
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		return numberOfEntries == size;
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T pop() {
		Node newNode = null;
		if (isEmpty()){
			return null;
		}else{
			newNode = head;
			head = newNode.next;
			numberOfEntries--;
			return newNode.data;
		}
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.numberOfEntries;
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean push(T e) {
		if (isFull()){
			return false;
		} else{
			Node newNode = new Node(e, null);
			if (head==null){
				head = newNode;
			} else{
				newNode.next = head;
				head = newNode;
			}
			numberOfEntries++;
			return true;
		}
	}
	
	/**
	 * Returns the elements of the Stack in an array, [0] is top of Stack, [1] is next in Stack, etc.
	 * @return an array of the Objects in the Stack
	 */
	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[])new Object[this.numberOfEntries];
		Node cur = head;
		int count = 0;
		while(cur != null){
			array[count++] = cur.data;
			cur = cur.next;
		}
		// Reverse the order using array
		@SuppressWarnings("unchecked")
		T[] array2 = (T[])new Object[this.numberOfEntries];
		int count2 = 0;
		for(int i = array.length - 1; i>= 0; i--){
			array2[count2++] = array[i];
		}
		return (array2);
		
	}
	
	/**
	 * print contents of the queue. The method is used for debug purposes.
	 */
	public void print_stack(){
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
	 * Inner class Node which is used to implement MyStack
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
