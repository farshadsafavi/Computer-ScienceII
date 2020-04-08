
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the ConcordanceDataManager
 * which is implemented from the ConcordanceDataManagerInterface
 * 
 * @author Professor Kartchner
 *
 */
public class ConcordanceDataManager_STUDENT_Test {
	private ConcordanceDataManagerInterface concordanceManager = new ConcordanceDataManager();
	private File inputFile, outputFile;
	private String text;

	/**
	 * Create an instance of ConcordanceDataManager
	 * Create a string for testing
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		concordanceManager = new ConcordanceDataManager();
		text = "I am Farshad Safavi\nMy father's name is Farhad Safavi.\n"+
				"I think Farshad is the best name in the world.\n"
				+ "Farshad Safavi is son of Farhad Safavi.";
	}

	/**
	 * Set concordanceManager reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		concordanceManager = null;
	}

	/**
	 * Test for the createConcordanceArray method
	 * Use the String text created in setUp()
	 */
	@Test
	public void testCreateConcordanceArray() {
		ArrayList<String> words = concordanceManager.createConcordanceArray(text);
//		System.out.println(words);
		assertEquals(words.get(0),"best: 3\n");
		assertEquals(words.get(1),"farhad: 2, 4\n");
		assertEquals(words.get(2), "farshad: 1, 3, 4\n");
		assertEquals(words.get(3),"father's: 2\n");
		assertEquals(words.get(4),"name: 2, 3\n");
		assertEquals(words.get(5),"safavi: 1, 2, 4\n");
		assertEquals(words.get(6),"son: 4\n");
		assertEquals(words.get(7),"think: 3\n");
		assertEquals(words.get(8),"world: 3\n");
	}
	
	
	/**
	 * Test for createConcordanceFile method
	 * This is intended to be used with the test file:
	 * Now_is_the_time.txt
	 */
	@Test
	public void testCreateConcordanceFileA() {
		ArrayList<String> words = new ArrayList<String>();
		try {
			inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.print("armin navid armita firouzeh nana\narmin navid armita firouzeh nana.\n"+
					"armin navid armita firouzeh nana.\n"
					+ "ali baba book cat dog erfan");
			
			inFile.close();
			outputFile = new File("Test1Out.txt");
			PrintWriter outFile = new PrintWriter(outputFile);
			outFile.print(" ");
			
			concordanceManager.createConcordanceFile(inputFile, outputFile);
			Scanner scan = new Scanner(outputFile);
			while (scan.hasNext())
			{
				words.add(scan.nextLine());
			}

			scan.close();
			outFile.close();
//			System.out.println(words.toString());
			assertEquals(words.get(0),"ali: 4");
			assertEquals(words.get(1), "armin: 1, 2, 3");
			assertEquals(words.get(2),"armita: 1, 2, 3");
			assertEquals(words.get(3),"baba: 4");
			assertEquals(words.get(4),"book: 4");
			assertEquals(words.get(5),"cat: 4");
			assertEquals(words.get(6),"dog: 4");
			assertEquals(words.get(7),"erfan: 4");
			assertEquals(words.get(8),"firouzeh: 1, 2, 3");
			assertEquals(words.get(9),"nana: 1, 2, 3");
			assertEquals(words.get(10),"navid: 1, 2, 3");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an FileNotFoundException");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an Exception");
		}
	}
//
	/**
	 * Test for createConcordanceFile method
	 * Create an inputFile "Test.txt" 
	 * and an outputFile "TestOut.txt"
	 */
	
	@Test
	public void testCreateConcordanceFileB() {
		ArrayList<String> words = new ArrayList<String>();
		try {
			inputFile = new File("Test2.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.print("A concordance lists every word that occurs in a document\n"
					+ "in alphabetical order, and for each word it gives the line number\n"
					+ "of every line in the document where the word occurs.");
			inFile.close();
			outputFile = new File("TestOut1.txt");
			PrintWriter outFile = new PrintWriter(outputFile);
		 
			concordanceManager.createConcordanceFile(inputFile, outputFile);
			Scanner scan = new Scanner(outputFile);
			while (scan.hasNext())
			{
				words.add(scan.nextLine());
				
			}

			scan.close();
			outFile.close();
//		for(int i=0; i<words.size(); i++)
//			System.out.println(words.get(i));
		
			 
			assertEquals("alphabetical: 2", words.get(0));
			assertEquals("concordance: 1", words.get(1));
			assertEquals("document: 1, 3", words.get(2));
			assertEquals("every: 1, 3", words.get(4));
			assertEquals("for: 2", words.get(5));
			assertEquals("gives: 2", words.get(6));
			assertEquals("line: 2, 3", words.get(7));
			assertEquals("lists: 1", words.get(8));
			assertEquals("word: 1, 2, 3", words.get(14));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateConcordanceFileC() {
		try {
			inputFile = new File("Test.txt");
			inputFile.setReadable(false);
			outputFile = new File("TestOut.txt");
			PrintWriter outFile = new PrintWriter(outputFile);
			outFile.print(" ");
			
			concordanceManager.createConcordanceFile(inputFile, outputFile);
			assertTrue("This should have raised an exception", false);
			outFile.close();
		
		} catch (FileNotFoundException e) {
			assertTrue("This should have raised a FileNotFoundexception", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateConcordanceFileD() {
		try {
			inputFile = new File("Test3.txt");
			outputFile = new File("Test3Out.txt");
			outputFile.setWritable(false);
			
			concordanceManager.createConcordanceFile(inputFile, outputFile);
			assertTrue("This should have raised an exception", false);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			assertTrue("This should have raised a FileNotFoundException", true);
		}
	}
	
}
