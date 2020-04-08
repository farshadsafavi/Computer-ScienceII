import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConcordanceDataManager implements ConcordanceDataManagerInterface{
	
	@Override
	public ArrayList<String> createConcordanceArray(String input) {
		String[] words = input.split("\\s+");
		ConcordanceDataStructure hs = new ConcordanceDataStructure(words.length);
//		System.out.println(hs.getTableSize());
//		System.out.println(input);
		String [] res = input.split("\\r?\\n");
		int lineNum = 0;
		for(String line:res){
//			System.out.println(line);
			lineNum++;
//			System.out.println(lineNum);
			String[] words_in_line = line.replaceAll("[^a-zA-Z' ]", "").toLowerCase().split("\\s+");
//			for(String s:words_in_line)
//				System.out.println(s);

			for(String word:words_in_line){
//				System.out.println(word + " "  + lineNum);
				hs.add(word, lineNum);
			}
//			System.out.println(line);
			
		}
//		System.out.println(hs.showAll());
		return hs.showAll();
	}

	@Override
	public boolean createConcordanceFile(File input, File output) throws FileNotFoundException {
//		System.out.println("**Reading a file starts:**");
		String st = "";
		
		Scanner myReader = new Scanner(input);
		while (myReader.hasNextLine()) {
	        st += myReader.nextLine() + "\n";
        }
	    myReader.close();
//	    System.out.println(st);
		    
		
		ArrayList<String> arr_list = createConcordanceArray(st);
//		System.out.println("**Writing a file starts:**");
		
			FileWriter myWriter;
			try {
				myWriter = new FileWriter(output);
				for(String word:arr_list){
					myWriter.write(word);	
				}
				myWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return false;
	}

	

}
