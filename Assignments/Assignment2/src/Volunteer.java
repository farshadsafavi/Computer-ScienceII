/**
 * 
 * @author Farshad Safavi
 *
 */
public class Volunteer {
	private String name;
	/**
	 * constructor for volunteer class
	 * @param name
	 */
	public Volunteer(String name) {
		// TODO Auto-generated constructor stub
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return name;
	}

}
