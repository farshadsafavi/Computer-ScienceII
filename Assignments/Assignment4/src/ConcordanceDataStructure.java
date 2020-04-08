import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ConcordanceDataStructure implements ConcordanceDataStructureInterface {
	private int size;
	private ArrayList<LinkedList<ConcordanceDataElement>> hs;
	
	/*
	 * Example if you estimated 500 words, 500/1.5 = 333. The next 4K+3 prime over 333 is 347. So you would make the table a length of 347. 
	 * The other constructor will take in a String and an int. 
	 * The string will be "Testing" and the int will be the size of the hash table. This is used only for testing.
	 */
	public ConcordanceDataStructure(String string, int size) {
//		int N = fourKPlus3(size, 1.5);   
//		System.out.println(N);
		hs = new ArrayList<LinkedList<ConcordanceDataElement>>(size);
		
		for(int i = 0; i < size; i++){
			hs.add(new LinkedList<ConcordanceDataElement>());
		}
		this.size = size;
	}

	/*
	 * Example if you estimated 500 words, 500/1.5 = 333. The next 4K+3 prime over 333 is 347. So you would make the table a length of 347. 
	 * The other constructor will take in a String and an int. 
	 * The string will be "Testing" and the int will be the size of the hash table. This is used only for testing.
	 */
	public ConcordanceDataStructure(int size) {  
		int N = fourKPlus3(size, 1.5);   
//		System.out.println(N);
		hs = new ArrayList<LinkedList<ConcordanceDataElement>>(N);
		for(int i = 0; i < N; i++){
			hs.add(new LinkedList<ConcordanceDataElement>());
		}
		this.size = N;
	}

	@Override
	public int getTableSize() {
		return size;
	}

	@Override
	public ArrayList<String> getWords(int index) {
		ArrayList<String> words = new ArrayList<String>();
		for(int i = 0; i < hs.get(index).size(); i++){
			words.add(hs.get(index).get(i).getWord());
		}
		return words;
	}

	@Override
	public ArrayList<LinkedList<Integer>> getPageNumbers(int index) {
		ArrayList<LinkedList<Integer>> pageNumbers = new ArrayList<LinkedList<Integer>>();
		for(int i = 0; i < hs.get(index).size(); i++){
			pageNumbers.add(hs.get(index).get(i).getList());
		}
		return pageNumbers;
	}

	@Override
	public void add(String word, int lineNum) {
		ConcordanceDataElement d = new ConcordanceDataElement(word, size);
		if(word.length()<=2 || word.equals("and") || word.equals("the")) return;
		if(hs.get(d.hashCode()).isEmpty()){
			LinkedList<ConcordanceDataElement> new_linkedlist = new LinkedList<ConcordanceDataElement>();
			new_linkedlist.addLast(d);
			d.addPage(lineNum);
			hs.set(d.hashCode(), new_linkedlist);
		} else{
			for(int i = 0; i < hs.get(d.hashCode()).size();i++){
				if(d.compareTo(hs.get(d.hashCode()).get(i)) == 0 ){
					if(!hs.get(d.hashCode()).get(i).getList().contains(lineNum)){
						hs.get(d.hashCode()).get(i).addPage(lineNum);
					}
				// if the word is not in the linkedlist add it
				} else{
					if(!hs.get(d.hashCode()).contains(d)){
						d.addPage(lineNum);
						hs.get(d.hashCode()).addLast(d);
						
					}
				} 
			}
		}
		
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> all = new ArrayList<String>();
		for(int i = 0; i < hs.size(); i++){
			for(int j = 0; j < hs.get(i).size(); j++){
//				System.out.println(hs.get(i).get(j).toString());
				all.add(hs.get(i).get(j).toString());
			}
		}
		Collections.sort(all);
		return all;
	}
	
	private int fourKPlus3(int n, double loadfactor)
	{  boolean fkp3 = false;
	   boolean aPrime = false;
	   int prime, highDivisor, d;

	   prime = (int)(n/loadfactor);
	   if(prime % 2 == 0) // if even make odd
	      prime = prime +1;
	   while(fkp3 == false) // not a 4k+3 prime
	   {  while(aPrime == false) // not a prime
	      {  highDivisor = (int)(Math.sqrt(prime) + 0.5);
	         for(d = highDivisor; d > 1; d--)
	         {  if(prime % d == 0)
	               break; // not a prime
	         }
	         if(d != 1) // prime not found
	            prime = prime + 2;
	         else
	            aPrime = true;
	      } // end of the prime search loop
	      if((prime - 3) % 4 == 0)
	         fkp3 = true;
	      else
	      {  prime = prime + 2;
	         aPrime = false;
	      }
	   } // end of 4k+3 prime search loop
	   return prime;
	}



}
