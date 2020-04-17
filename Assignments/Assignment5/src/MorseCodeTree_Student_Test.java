import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeTree_Student_Test {
	MorseCodeTree mct;
	@Before
	public void setUp() throws Exception {
		mct = new MorseCodeTree();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrintTree()
	{
		String str = "hsvifuelrapwjbdxnckytzgqmo";
		ArrayList<String> arr = new ArrayList<String>();
		for(int i = 0; i < str.length(); i++){
			if (String(str.charAt(i)) != " "){
				String n = str.charAt(i) + "";
				n.trim();
				arr.add(n);
			}
		}
		ArrayList<String> s = new ArrayList<String>();
		
		for(String i:mct.toArrayList()){
			if (i != ""){
				s.add(i);
			}
		}
		
		assertEquals(arr, s);
	}
	
	private String String(char charAt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish("--. --- --- -.. -... -.-- . / .-- --- .-. .-.. -.. ");
		System.out.println(converter1);
		assertEquals("goodbye world",converter1);
		
		String test2="daisy daisy";		
		String converter2 = MorseCodeConverter.convertToEnglish("-.. .- .. ... -.-- / -.. .- .. ... -.-- ");
		assertEquals("daisy daisy", converter2);
	}

}
