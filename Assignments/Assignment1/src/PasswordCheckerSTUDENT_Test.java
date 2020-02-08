
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import _solution.InvalidSequenceException;
import _solution.LengthException;
import _solution.NoDigitException;
import _solution.NoLowerAlphaException;
import _solution.NoUpperAlphaException;
import _solution.PasswordCheckerUtility;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> passwords;
	
	@Before
	public void setUp() throws Exception {
		String[] p = {"123Password", "pawor", "password", "PASSWORD", "Password", "Password1", 
				"Pas123f", "123456", "Fa_111111234@7&8*****", "aa11bA", "pilotttProject2", "HelllowWorld", 
				"HellowWorld2"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p)); // puts strings into the ArrayList

	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("123Password"));
			assertTrue(PasswordCheckerUtility.isValidPassword("123456AbaaAAbb"));
			PasswordCheckerUtility.isValidPassword("pawor");
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Threw a lengthExcepetion successfully",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception in addition to lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("xxyyzzwwaa12P"));
			PasswordCheckerUtility.isValidPassword("xxyyzzwwaa");
			assertTrue("Did not throw NoUpperAlphaException",false);
		}catch(NoUpperAlphaException e){
			assertTrue("Threw a NoUpperAlphaException successfully",true);
		}catch(Exception e){
			assertTrue("Threw some other exception in addition to NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("PA111SS2WORD1a"));
			PasswordCheckerUtility.isValidPassword("PA111SS2WORD1");
			assertTrue("Did not throw NoLowerAlphaException",false);
		}catch(NoLowerAlphaException e){
			assertTrue("Threw a NoLowerAlphaException successfully",true);
		}catch(Exception e){
			assertTrue("Threw some other exception in addition to NoLowerAlphaException",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("Farshad1234"));
			boolean weak_password = PasswordCheckerUtility.isWeakPassword("Fsh123");
			assertTrue(weak_password);
			weak_password = PasswordCheckerUtility.isWeakPassword("Farshad1234");
			assertFalse(weak_password);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
			
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("1234aaAA"));
			PasswordCheckerUtility.isValidPassword("aaaBB123");
			assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception in addition to an InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("AaaBB123AA"));
			PasswordCheckerUtility.isValidPassword("AaaBBAAcc");
			assertTrue("Did not throw an NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Threw an NoDigitException successfully ",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception in addition to NoDigitException",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("Im2cool4U"));
			assertEquals(true,PasswordCheckerUtility.isValidPassword("george2ZZ"));
			assertEquals(true,PasswordCheckerUtility.isValidPassword("LetsTestPassword123"));
			assertEquals(true,PasswordCheckerUtility.isValidPassword("NOo0?_-09-WAAYY"));
			assertEquals(true,PasswordCheckerUtility.isValidPassword("Iam_so_&$@_12"));
			PasswordCheckerUtility.isValidPassword("AaaBBAAcc1");
			assertTrue("Did not throw an Exception",true);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			assertFalse("Threw an exception",true);
		}
		
	}
	
	/**
	 * Test the validPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	
	@Test
	public void testValidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.validPasswords(passwords);
		Scanner scan = new Scanner(results.get(0)); 
		assertEquals(scan.next(), "pawor");
		String nextResults = scan.nextLine().toLowerCase();
		// The password is too short.
		assertTrue(nextResults.contains("at least 6 characters long"));
		
		scan = new Scanner(results.get(1)); 
		assertEquals(scan.next(), "password");
		nextResults = scan.nextLine().toLowerCase();
		// The password must contain at least one uppercase alphabetical character
		assertTrue(nextResults.contains("uppercase"));
		
		scan = new Scanner(results.get(2)); 
		assertEquals(scan.next(), "PASSWORD");
		nextResults = scan.nextLine().toLowerCase();
		// The password must contain at least one lowercase alphabetical character
		assertTrue(nextResults.contains("lowercase"));
		
		scan = new Scanner(results.get(3)); //
		assertEquals(scan.next(), "Password");
		nextResults = scan.nextLine().toLowerCase();
		// The password must contain at least one digit
		assertTrue(nextResults.contains("digit"));
		
		scan = new Scanner(results.get(4)); //
		assertEquals(scan.next(), "123456");
		nextResults = scan.nextLine().toLowerCase();
		// The password must contain at least one uppercase alphabetical character
		assertTrue(nextResults.contains("uppercase"));
		
		scan = new Scanner(results.get(5)); //
		assertEquals(scan.next(), "pilotttProject2");
		nextResults = scan.nextLine().toLowerCase();
		// The password must contain more than two sequences of the same character
		assertTrue(nextResults.contains("sequence"));
		
		scan = new Scanner(results.get(6)); //a
		assertEquals(scan.next(), "HelllowWorld");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
		
		assertEquals(7, results.size());
		
	}
	
}
