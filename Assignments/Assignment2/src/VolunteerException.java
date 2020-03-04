/**
 * 
 * @author Farshad Safavi
 * 
 */

public class VolunteerException extends Exception {
	public VolunteerException(){};
	/**
	 * A class which is used when a user throw an exception 
	 * when volunteer line is full or empty
	 * @param message
	 */
	public VolunteerException(String message) {
		super(message);
	}

}
