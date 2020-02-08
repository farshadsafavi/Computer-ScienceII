package _solution;
/**
 * 
 */

/*********************************************************************
 * @author Farshad Safavi
 ********************************************************************/
public class NoDigitException extends UnmatchedException{
	
	
	/****************************************************************
	 *  NoDigitException with a message the password must contain at 
	 *  least one digit.
	 ****************************************************************/
	public NoDigitException(){
		super("The password must contain at least one digit.");
	} // end default constructor
	
	
	/****************************************************************
	 *  NoDigitException with a user message
	 *  @param message is string
	 ****************************************************************/ 
	public NoDigitException(String message){
	    super(message);
	} // end constructor
	
	
	/****************************************************************
	 * A string message the password must contain at least one digit.
	 ****************************************************************/
	public String toString(){
		return "The password must contain at least one digit.";
	}

}
