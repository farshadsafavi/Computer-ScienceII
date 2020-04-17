import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeConverter {
	public static MorseCodeTree mct = new MorseCodeTree();
	

	public static String printTree() {
		String st = "";
		for(String i:mct.toArrayList()){
			st += i + " ";
		}
		return st;
	}
	

	public static String convertToEnglish(String text) {
		String[] list_words = text.split(" / ");
		String translation = "";
		for(String word:list_words){
			String[] list_codes = word.split(" ");
			for(String code:list_codes){
				translation += mct.fetch(code);
			}
			translation += " ";
		}
		translation = translation.trim();
		return translation;
	}
	
	public static String convertToEnglish(File selectedFile) throws FileNotFoundException  {
	      Scanner myReader = new Scanner(selectedFile);
	      String text = "";
	      while (myReader.hasNextLine()) {
			  String data = myReader.nextLine();
			  text += data;
		  }
		  myReader.close();
		  return convertToEnglish(text);
	}

}
