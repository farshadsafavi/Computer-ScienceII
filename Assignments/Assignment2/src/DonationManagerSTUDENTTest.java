
import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 
/**
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */
public class DonationManagerSTUDENTTest {
	DonationManager manager;

	@Before
	public void setUp() throws Exception {
	 
		manager = new DonationManager();
		
	}
 
	@After
	public void tearDown() throws Exception {
		 
		manager = null;
	}
 
	/** 
	 * Student test that a new DonationPackage is created and 
	 * the manager correctly calls load the container 
	 */
	@Test
	public void testManagerLoadcontainer()   {
		DonationPackage d1 = new DonationPackage("Calculators",10);
		DonationPackage d2 = new DonationPackage("Tables",15);
		DonationPackage d3 = new DonationPackage("Bags",11);
		DonationPackage d4 = new DonationPackage("WhiteBoard",20);
		DonationPackage d5 = new DonationPackage("Printers",14);
		DonationPackage[] array = {d1, d2, d3, d4, d5};
		try {
			manager.managerLoadContainer(d1);
			manager.managerLoadContainer(d2);
			manager.managerLoadContainer(d3);
			manager.managerLoadContainer(d4);
			manager.managerLoadContainer(d5);
			int i = 0;
			for (DonationPackage d:manager.managerArrayPackage()){
				assertEquals(d,array[i++]);
			}
		} catch (ContainerException e) {
			System.out.println("Should not throw exception ");
		}	 	 
	    
	}
	 
	/**
	 * Student test that a new Volunteer is created and 
	 * the manager correctly queues the volunteer
	 */
	@Test
	public void testManagerQueueVolunteer() {
		Volunteer v1 = new  Volunteer("Jill");
		Volunteer v2 = new  Volunteer("Navid");
		Volunteer v3 = new  Volunteer("Aliss");
		Volunteer v4 = new  Volunteer("Venon");
		Volunteer v5 = new  Volunteer("Fari");
		Volunteer[] array = {v1, v2, v3, v4, v5};
		try {
			manager.managerQueueVolunteer(v1);
			manager.managerQueueVolunteer(v2);
			manager.managerQueueVolunteer(v3);
			manager.managerQueueVolunteer(v4);
			manager.managerQueueVolunteer(v5);
			int i = 0;
			for (Volunteer v:manager.managerArrayVolunteer()){
				assertEquals(v,array[i++]);
			}
		} catch (VolunteerException e) {
			System.out.println(e + "here");
		}	 
	
	}

	/**
	 * Student test that a new Recipient is created and 
	 * the manager correctly queues the recipient
	 */
	@Test
	public void testManagerQueueRecipient() {
		Recipient r1 = new  Recipient("MC");
		Recipient r2 = new  Recipient("Rockville");
		Recipient r3 = new  Recipient("SilverSpring");
		Recipient r4 = new  Recipient("UMD");
		Recipient r5 = new  Recipient("UBC");
		Recipient[] array = {r1, r2, r3, r4, r5};
		try {
			manager.managerQueueRecipient(r1);
			manager.managerQueueRecipient(r2);
			manager.managerQueueRecipient(r3);
			manager.managerQueueRecipient(r4);
			manager.managerQueueRecipient(r5);
			int i = 0;
			for (Recipient v:manager.managerArrayRecipient()){
				assertEquals(v,array[i++]);
			}
		} catch (RecipientException e) {
			System.out.println(e + "here");
		}	
	}

	/**
	 * Student test that the manager correctly calls donatePackage,
	 * testing the situations noted in the assignment document
	 */
	@Test
	public void testDonatePackage() {
		// Donation packages
		DonationPackage d1 = new DonationPackage("Calculators",10);
		DonationPackage d2 = new DonationPackage("Tables",15);
		DonationPackage d3 = new DonationPackage("Bags",11);
		DonationPackage d4 = new DonationPackage("WhiteBoard",20);
		DonationPackage d5 = new DonationPackage("Printers",14);
		// Volunteers
		Volunteer v1 = new  Volunteer("Jill");
		Volunteer v2 = new  Volunteer("Navid");
		Volunteer v3 = new  Volunteer("Aliss");
		Volunteer v4 = new  Volunteer("Venon");
		Volunteer v5 = new  Volunteer("Fari");
		// Recipients
		Recipient r1 = new  Recipient("MC");
		Recipient r2 = new  Recipient("Rockville");
		Recipient r3 = new  Recipient("SilverSpring");
		Recipient r4 = new  Recipient("UMD");
		Recipient r5 = new  Recipient("UBC");
		try {
			// load container
			manager.managerLoadContainer(d1);
			manager.managerLoadContainer(d2);
			manager.managerLoadContainer(d3);
			manager.managerLoadContainer(d4);
			manager.managerLoadContainer(d5);
			// Enqueue in Volunteer Queue
			manager.managerQueueVolunteer(v1);
			manager.managerQueueVolunteer(v2);
			manager.managerQueueVolunteer(v3);
			manager.managerQueueVolunteer(v4);
			manager.managerQueueVolunteer(v5);
			// Enqueue in Recipient Queue
			manager.managerQueueRecipient(r1);
			manager.managerQueueRecipient(r2);
			manager.managerQueueRecipient(r3);
			manager.managerQueueRecipient(r4);
			manager.managerQueueRecipient(r5);
			
			assertEquals(manager.donatePackage(),4);
			assertEquals(manager.donatePackage(),3);
			assertEquals(manager.donatePackage(),2);
			assertEquals(manager.donatePackage(),1);
			assertEquals(manager.donatePackage(),0);
			
		} catch (ContainerException | VolunteerException | RecipientException e) {
			 
			e.printStackTrace();
		}
	} 

}
