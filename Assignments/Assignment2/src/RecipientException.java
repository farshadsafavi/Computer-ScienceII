/**
 * 
 * @author Farshad Safavi
 * 
 */
public class RecipientException extends Exception {

		public RecipientException(){};
		/**
		 * A class which is used when a user throw an exception when 
		 * Recipient line is full or empty
		 * @param message
		 */
		RecipientException(String message) {
			super(message);
		}


}
