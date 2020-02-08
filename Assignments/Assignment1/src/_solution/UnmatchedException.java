package _solution;

/*****************************************************************
 * @author Farshad Safavi
 ****************************************************************/
public class UnmatchedException extends RuntimeException{
	
	
	/***************************************************************
	 * UnmatchedException with a message the password do not match.
	**************************************************************/
	public UnmatchedException(){
		super("The passwords do not match.");
	} // end default constructor
	
	
	/***************************************************************
	 * UnmatchedException with a message the password do not match.
	 * @param message is string
	**************************************************************/
	public UnmatchedException(String message){
	    super(message);
	} // end constructor

}