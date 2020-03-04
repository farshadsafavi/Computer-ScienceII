/**
 * 
 * @author Farshad Safavi
 */
public class VolunteerLine implements VolunteerLineInterface{
	private int size;
	private MyQueue<Volunteer> queue;
	
	/**
	 * VolunteerLine() make internal queue default size
	 * VolunteerLine class that implements VolunteerLineInterface.
	 * This class contains a queue of Volunteers and simulates queuing 
	 * and dequeuing volunteers to and from the volunteers’ line.
	 */
	public VolunteerLine() {
		size = 5;
		queue = new MyQueue<Volunteer>(size);
	}
	
	/**
	 * VolunteerLine(int size) make internal queue this size
	 * @param size
	 */
	public VolunteerLine(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
		queue = new MyQueue<Volunteer>(this.size);
	}
	
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Queue is full") is queue is full
	 */
	@Override
	public boolean addNewVolunteer(Volunteer v) throws VolunteerException {
		// TODO Auto-generated method stub
		if (queue.isFull()){
			throw new VolunteerException("Volunteer Queue is full");
		} else{
			queue.enqueue(v);
			return true;
		}
	}
	
	/**
	 * removes volunteer from the volunteer queue line
	 * @return Volunteer Object
	 * @throws VolunteerException("Volunteer queue is empty") if queue is empty
	 */
	@Override
	public Volunteer volunteerTurn() throws VolunteerException {
		// TODO Auto-generated method stub
		if (volunteerLineEmpty()){
			throw new VolunteerException("Volunteer queue is empty");
		} else{
			return queue.dequeue();
		}
	}
	
	
	/**
	 * checks if there are volunteers in line 
	 * @return true if volunteer line is empty, true otherwise
	 */
	@Override
	public boolean volunteerLineEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}
	
	/**
	 * Returns an array of the Volunteers in the queue.  
	 * Because of type erasure by the JVM at run-time, the array of type T that the generic queue
	 * returns from the call to queue.toArray() is an array of type Object, i.e., Object[] temp. 
	 * But since the individual elements of the array are still Volunteers, we can copy them one 
	 * by one into a new array	of type Volunteer and cast each one to Volunteer. 
	 * So create a new array of Volunteers of the same length as temp, run a for-loop that casts each element 
	 * of temp to Volunteer and copies it to the corresponding position in the new array.  Then return the new array.
	 * @return an array of the Volunteers in the queue
	 */
	@Override
	public Volunteer[] toArrayVolunteer() {
		// TODO Auto-generated method stub
		
		Volunteer[] array_v = new Volunteer[queue.size()];
		Object[] array = queue.toArray();
		int count = 0;
		for (Object o:array){
			array_v[count++] = (Volunteer) o; 
		}
		return array_v;
	}
	
	/**
	 * returns number of entries in volunteer line
	 * @return
	 */
	public int getNumberOfEntries(){
		return queue.getNumberOfEntries();
	}

}
