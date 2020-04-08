import java.util.Collections;
import java.util.LinkedList;

public class ConcordanceDataElement implements Comparable<ConcordanceDataElement>{
	private String word;
	private LinkedList<Integer> ls;
	private int size;
	public ConcordanceDataElement(String word, int size){
		this.word = word;
		ls = new LinkedList<Integer>();
		this.size = size;
	}

	public String toString(){
		String ls_nums = "";
		int count = 0;
		for(Integer i:ls){
			if(count==0)
				ls_nums += i.toString();
			else
				ls_nums += ", " + i.toString();
			count++;	
		}
		return word + ": " +  ls_nums+ "\n";
	}
	
	public int hashCode(){
		if (word.hashCode()%size >= 0){
			return word.hashCode()%size;
		}else{
			return 0;
		}
	    
		
	}
	
	public LinkedList<Integer> getList(){
		Collections.sort(ls);
		return ls;
	}

	public void addPage(int lineNum){
//		System.out.println(lineNum);
		if(!ls.contains((Integer)lineNum)){
			ls.add(lineNum);
		}
//		Collections.sort(ls);
	}
	
	public String getWord(){
		return word;
	}
	
	@Override
	public int compareTo(ConcordanceDataElement o) {
		return this.word.compareTo(o.word);
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof ConcordanceDataElement))
            return false;
        ConcordanceDataElement employee = (ConcordanceDataElement) obj;
        return employee.getWord().equals(this.word);
    }

}
