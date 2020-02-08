package _solution;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/************************************************************************************
 * @author Farshad Safavi
 ************************************************************************************/
public class PasswordCheckerUtility {

	
	/***************************************************************************************
	 * isValidPassword method checks the validity of one password and return true if the 
	 * password is valid and throw an exception if invalid.  
	 * @param passwordString is String
	 * @return return true if the password is valid and throw an exception if invalid.
	 * @throws LengthException if password is less than 6 characters
	 * @throws NoDigitException if password contains no digit
	 * @throws NoUpperAlphaException if password contains no uppercase
	 * @throws NoLowerAlphaException if password contains no lowercase
	 * @throws InvalidSequenceException if password contains more than 2 of the same 
	 * character in sequence 
	 **************************************************************************************/
	public static boolean isValidPassword(String passwordString)throws LengthException,
																	   NoDigitException,
																	   NoUpperAlphaException,
																	   NoLowerAlphaException,
																	   InvalidSequenceException{
		
		// 1. Valid if password is greater than or equal to 6 characters
		if(passwordString.length() < 6){
			throw new LengthException(); 
		}
		// 2. Password doesn’t contain an upper-case alpha character
		else if(!passwordString.matches(".*[A-Z].*")){
			throw new NoUpperAlphaException();
		}
		// 3.Password doesn’t contain a lower-case alpha character
		else if(!passwordString.matches(".*[a-z].*")){
			throw new NoLowerAlphaException();
		}
		// 4. Password doesn’t contain a numeric character 
		else if(!passwordString.matches(".*\\d+.*")){
			throw new NoDigitException(); 
		}
		// 5. Password contains more than 2 of the same character in sequence 
		else if(passwordString.matches(".*([a-zA-Z])\\1{2,}.*")){
			throw new InvalidSequenceException();
		}else{
			return true;
		}
	}
	
	
	/********************************************************************************
	 * validPasswords method checks an ArrayList of passwords and return an ArrayList 
	 * with the status of any invalid passwords (weak passwords are not considered 
	 * invalid).  
	 * The ArrayList of invalid passwords will be of the following format:
	 * password space message of exception thrown
	 * @param passwords String
	 * @return ArrayList of String invalidPasswords
	 ********************************************************************************/
	public static ArrayList<String> validPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		// iterate passwords and check the password is valid. Add invalid passwords 
		// messages to inavalidPasswords ArrayList
		for (String password:passwords){
			try{
				isValidPassword(password);
			}catch(Exception e){
				invalidPasswords.add(password + " " + e.toString());
				//System.out.println(password + e.toString());
			}
		}
		//System.out.print(invalidPasswords);
		return invalidPasswords;
	}
	
	/**********************************************************************************
	 * isWeakPassword method checks for a “weak password”, i.e., one whose length 
	 * is between 6 and 9, inclusive. Do NOT throw an exception.
	 * @param passwordString String
	 * @return true if less than or equal to 9 characters and false otherwise
	 *********************************************************************************/
	public static boolean isWeakPassword(String passwordString) {
		return passwordString.length() <= 9;
	}

}
