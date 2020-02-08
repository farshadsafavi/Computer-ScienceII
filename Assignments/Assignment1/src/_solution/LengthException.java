package _solution;
/**
 * 
 */

/************************************************************
 * @author Farshad safavi
 ****************************************************************/
public class LengthException extends UnmatchedException{
	
	
	/*************************************************************
	 * LengthException with a message the password must be at least 
	 * 6 characters long.
	*************************************************************/
	public LengthException(){
		super("The password must be at least 6 characters long.");
	} // end default constructor
	
	
	/**************************************************************
	 * LengthException with user message
	 * @param message is string
	**************************************************************/
	public LengthException(String message){
	    super(message);
	} // end constructor
	
	
	/***************************************************************
	 * A string message is the password must be at least 6 characters 
	 * long.
	***************************************************************/
	public String toString(){
		return "The password must be at least 6 characters long.";
	}
}
