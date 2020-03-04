/**
 * 
 * @author Farshad Safavi
 * 
 */

public class ContainerException extends Exception {
	public ContainerException(){};
	/**
	 * ContainerException – similar to RecipientException except throws 
	 * ContainerException when the Volunteer Stack is full or empty
	 * @param message
	 */
	public ContainerException(String message) {
		super(message);
	}
}
