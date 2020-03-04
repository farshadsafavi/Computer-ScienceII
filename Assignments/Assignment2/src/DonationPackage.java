/**
 * 
 * @author Farshad Safavi
 */

public class DonationPackage {
	private String s;
	private double pWeight;
	
	/**
	 * Constructor which takes description and weight and produce Donation Package
	 * A class that generate donation packages based on weight and description
	 * @param s
	 * @param pWeight
	 */
	public DonationPackage(String s, double pWeight) {
		this.s = s;
		this.setpWeight(pWeight);
	}

	/**
	 * return String description of the package
	 * @return String
	 */
	public String getDescription() {
		return s;
	}

	/**
	 * This helper function is not used in the project
	 * @return true if the package is heavy or false otherwise
	 */
	public boolean isHeavy() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * return weight of the package
	 * @return double weight of the package
	 */
	public double getpWeight() {
		return pWeight;
	}
	
	/**
	 * Set  weight of the package
	 * @param pWeight
	 */
	public void setpWeight(double pWeight) {
		this.pWeight = pWeight;
	}
	
	/**
	 * gives the description of the package
	 * @return String description
	 */
	public String toString(){
		return getDescription();
	}
	

	

}
