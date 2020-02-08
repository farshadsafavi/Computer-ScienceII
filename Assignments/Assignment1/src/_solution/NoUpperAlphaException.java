package _solution;
/**
 * 
 */

/*****************************************************************
 * @author Farshad Safavi
 ****************************************************************/
public class NoUpperAlphaException extends UnmatchedException{
	
	
	/*************************************************************
	 * NoUpperAlphaException the password must contain at least 
	 * one uppercase alphabetic character.
	 ************************************************************/
	public NoUpperAlphaException(){
		super("The password must contain at least one uppercase "
				+ "alphabetic character.");
	} // end default constructor
	 
	
	/*************************************************************
	 * NoUpperAlphaException with a user message
	 * @param message is string
	 ************************************************************/
	public NoUpperAlphaException(String message){
	    super(message);
	} // end constructor
	
	
	/*************************************************************
	 * A string message the password must contain at least one 
	 * uppercase alphabetic character.
	 ************************************************************/
	public String toString(){
		return "The password must contain at least one uppercase "
				+ "alphabetic character.";
	}

}