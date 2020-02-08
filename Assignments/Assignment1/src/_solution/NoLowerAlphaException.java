package _solution;
/**
 * 
 */

/*********************************************************************
 * @author Farshad Safavi
 ********************************************************************/
public class NoLowerAlphaException extends UnmatchedException{
	
	 /******************************************************************
	 * NoLowerAlphaException with a message the password must contain at 
	 * least one lowercase alphabetic character.
	 ****************************************************************/
	public NoLowerAlphaException(){
		super("The password must contain at least one lowercase alphabetic"
				+ " character.");
	} // end default constructor
	
	 
	/****************************************************************
	 * NoLowerAlphaException with a user message.
	 * @param message is string
	 ****************************************************************/
	public NoLowerAlphaException(String message){
	    super(message);
	} // end constructor
	
	
	/******************************************************************
	 * A string message the password must contain at least one lowercase 
	 * alphabetic
	 *****************************************************************/
	public String toString(){
		return "The password must contain at least one lowercase "
				+ "alphabetic character.";
	}

}