

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeConverter_Student_Test {
	File inputFile;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish("-- -.-- / -. .- -- . / .. ... / ..-. .- .-. ... .... .- -.. / ... .- ..-. .- ...- ..");
		assertEquals("my name is farshad safavi",converter1);
		
		String test2="every night in my dreams i see you i feel you";		
		String converter2 = MorseCodeConverter.convertToEnglish(". ...- . .-. -.-- / -. .. --. .... - / .. -. / -- -.-- / -.. .-. . .- -- ... / .. / ... . . / -.-- --- ..- / .. / ..-. . . .-.. / -.-- --- ..-");
		assertEquals(test2, converter2);
	}

	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException {
		String test1="how do i love thee let me count the ways";		
		getFile("LoveLooksNot.txt");
		String converter1 = MorseCodeConverter.convertToEnglish(inputFile);
		System.out.println(converter1);
		assertEquals(test1,converter1);
		
		String test2="no pain no gain that is the reality of world we live in";		
		getFile("nopain.txt");
		String converter2 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test2,converter2);

	}
	
	public void getFile(String in) throws FileNotFoundException {		
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if(status == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				inputFile = chooser.getSelectedFile();
				// readFile();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
