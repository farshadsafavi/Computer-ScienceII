/**
 * 
 * @author Farshad Safavi
 *  
 */
public class DonationManager implements DonationManageInterface{
	private Container container;
	private VolunteerLine volunteerLine;
	private RecipientLine recipientLine;
	
	private Volunteer v;
	private Recipient r;
	private DonationPackage c;
	
	/**
	 * Constructor DonationManager which initiates Container, VolunteerLine and RecipientLine
	 * The DonationManager class will manage adding a new package to the container, 
	 * a new volunteer to the volunteer queue line, a new recipient to the recipient 
	 * queue and donating package by the volunteer to the recipient.  The three methods 
	 * named managerArrayPackage, managerArrayRecipient, and managerArrayVolunteer place 
	 * their data elements in an array.  They all call the methods in the container, 
	 * volunteer line, and recipient line respectively, named toArrayPackage, toArrayVolunteer, 
	 * and toArrayRecipient.  Each of those methods calls toArray in MyStack or MyQueue. 
	 */
	public DonationManager(){
		container = new Container();
		volunteerLine = new VolunteerLine();
		recipientLine = new RecipientLine();
	}
	
	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage Donation package that is stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException if container is full
	 */
	@Override
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		// TODO Auto-generated method stub
		System.out.println("managerLoadContainer");
		return container.loadContainer(dPackage);
	}
	
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Line is full") if the Volunteer Line queue is full
	 */
	@Override
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		return volunteerLine.addNewVolunteer(v);
	}

	/**
	 * adds a new Recipient to the queue of the Recipient line
	 * @param rc a Recipient
	 * @return true if recipient is queued successfully , false if queue is full
	 * @throws RecipientException("Recipient Line is full") if the Recipient line is full
	 */
	@Override
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		return recipientLine.addNewRecipient(r);
	}
	
	/**
	 * Simulates donating a DonationPackage from the container stack by the volunteer from the volunteer queue line to the 
	 * recipients from the recipients queue line. As a result the package is removed from the container, volunteer will be dequeued
	 * from  volunteer line and QUEUED BACK to the volunteer line and recipient will be dequeued from the recipient line.
	 * @throws VolunteerException("Volunteer Queue is empty") if there are no volunteers
	 * @throws ContainerExcpetion("Contain is empty") if the container is empty
	 * @throws RecipientException("Recipient Queue is empty") if there are no recipients
	 * 
	 */
	@Override
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		
		c = container.removePackageFromContainer();
		r = recipientLine.recipientTurn();
		v = volunteerLine.volunteerTurn();
		volunteerLine.addNewVolunteer(v);
		
		return container.size();
	}

	/**
	 * Returns an array of DonationPackages
	 * @return an array of Donation Packages
	 */
	@Override
	public DonationPackage[] managerArrayPackage() {
		// TODO Auto-generated method stub
		return container.toArrayPackage();
	}

	/**
	 * Returns an array of Volunteers
	 * @return an array of Volunteers
	 */
	@Override
	public Volunteer[] managerArrayVolunteer() {
		// TODO Auto-generated method stub
		return volunteerLine.toArrayVolunteer();
	}
	
	/**
	 * Returns an array of Recipients
	 * @return an array of Recipients
	 */
	@Override
	public Recipient[] managerArrayRecipient() {
		// TODO Auto-generated method stub
		return recipientLine.toArrayRecipient();
	}
	
	/**
	 * provide the string to describe the transaction which describes packages delivered to destinations
	 */
	public String toString(){
		return v.getName() + " Delivered "+ c.getDescription() + " packages to " + r.getName();
	}

}
