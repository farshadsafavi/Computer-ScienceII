/**
 * 
 * @author Farshad Safavi
 *
 */
public class RecipientLine implements RecipientLineInterface{
	private int size;
	private MyQueue<Recipient> queue;
	/**
	 * Provide two constructors:
	 * RecipientLine(int size) make internal queue this size
	 * @param return size
	 */
	public RecipientLine(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
		queue = new MyQueue<Recipient>(size);
		
	}
	
	/**
	 * RecipientLine() make internal queue default size 5
	 */
	public RecipientLine() {
		// TODO Auto-generated constructor stub
		this.size = 5;
		queue = new MyQueue<Recipient>(this.size);
	}

	/**
	 * Enqueue a new Recipient to the queue of the Recipients in the Recipient line
	 * @param rc a Recipient
	 *return true if recipient is queued successfully
	 * @throws RecipientException("The Recipent Queue is Full") if queue is full
	 */
	@Override
	public boolean addNewRecipient(Recipient rc) throws RecipientException {
		if(queue.isFull()){
			throw new RecipientException("The Recipent Queue is Full");
		} else{
			queue.enqueue(rc);
			return true;
		}
	}
	
	/**
	 * When it is the recipient turn, recipient will be dequeued from the recipient line
	 * @return a Recipient object
	 * @throws RecipientException("The Recipient Queue is empty") if there is no Recipient in the line
	 */
	@Override
	public Recipient recipientTurn() throws RecipientException {
		if(recipientLineEmpty()){
			throw new RecipientException("The Recipient Queue is empty");
		} else{
			return queue.dequeue();
		}
	}
	
	/**
	 * check if Recipient  queue line is empty
	 * @return true if queue is empty, false otherwise
	 */
	@Override
	public boolean recipientLineEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}

	/**
	 * Returns an array of the Recipients in the queue.  
	 * Because of type erasure by the JVM at run-time, the array of type T that the generic queue
	 * returns from the call to queue.toArray() is an array of type Object, i.e., Object[] temp. 
	 * But since the individual elements of the array are still Recipients, we can copy them one 
	 * by one into a new array	of type Recipient and cast each one to Recipient. 
	 * So create a new array of Recipients of the same length as temp, run a for-loop that casts each element 
	 * of temp to Recipient and copies it to the corresponding position in the new array.  Then return the new array.
	 * @return an array of the Recipients in the queue
	 */
	@Override
	public Recipient[] toArrayRecipient() {
		// TODO Auto-generated method stub
		Recipient[] array_r = new Recipient[queue.size()];
		Object[] array = queue.toArray();
		int count = 0;
		for (Object o:array){
			array_r[count++] = (Recipient) o; 
		}
				
		
		return array_r;
	}
	
	/**
	 * returns number of entries in Recipient line
	 * @return
	 */
	public int getNumberOfEntries(){
		return queue.getNumberOfEntries();
	}

}
