package _solution;
/**
 * 
 */

/******************************************************************
 * @author Farshad Safavi
 ******************************************************************/
public class InvalidSequenceException extends UnmatchedException{
	
	
	/**************************************************************
	 * InvalidSequenceException a message is the password cannot 
	 * contain more than two of the same character in sequence.
	 *************************************************************/
	public InvalidSequenceException(){
		super("The password cannot contain more than two of the "
				+ "same character in sequence.");
	} // end default constructor
	
	
	/**************************************************************
	 * nvalidSequenceException with a user message
	 * @param message is string
	 **************************************************************/
	public InvalidSequenceException(String message){
	    super(message);
	} // end constructor
	
	
	/**************************************************************
	 * A string message the password contain more than two of the 
	 * same character in sequence.
	 **************************************************************/
	public String toString(){
		return "The password cannot contain more than two of the same "
				+ "character in sequence.";
	}

}