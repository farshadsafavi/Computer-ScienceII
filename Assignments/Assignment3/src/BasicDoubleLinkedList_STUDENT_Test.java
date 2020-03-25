

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedList_STUDENT_Test {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Car> linkedCar;
	StringComparator comparator;
	DoubleComparator comparatorD;
	CarComparator comparatorCar;
	
	public Car a=new Car("Ford", "F150", 2005);
	public Car b=new Car("Jeep", "Renegade", 2005);
	public Car c=new Car("Honda", "Civic", 2005);
	public Car d=new Car("Subaru", "Outback", 2005);
	public Car e=new Car("Chevrolet", "Silverado", 2005);
	public Car f=new Car("Chrysler", "PTCruiser", 2005);
	public Car g=new Car("peride", "hachback", 2005);
	public Car h=new Car("peikan", "Renegade", 2005);

	public ArrayList<Car> fill = new ArrayList<Car>();
	

	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("How");
		linkedString.addToEnd("Are");
		linkedString.addToEnd("You");
		linkedString.addToEnd("What");
		linkedString.addToEnd("Doing");
		comparator = new StringComparator();
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(15.0);
		linkedDouble.addToEnd(100.0);
		linkedDouble.addToEnd(1.0);
		linkedDouble.addToEnd(200.0);
		comparatorD = new DoubleComparator();
		
		linkedCar= new BasicDoubleLinkedList<Car>();
		linkedCar.addToEnd(a);
		linkedCar.addToEnd(b);
		linkedCar.addToEnd(c);
		linkedCar.addToEnd(d);
		comparatorCar = new CarComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		linkedDouble = null;
		linkedCar = null;
		comparatorD = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(5,linkedString.getSize());
		assertEquals(4,linkedDouble.getSize());
		assertEquals(4,linkedCar.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("Doing", linkedString.getLast());
		linkedString.addToEnd("Farshad");
		assertEquals("Farshad", linkedString.getLast());
		
		assertEquals(d,linkedCar.getLast());
		linkedCar.addToEnd(g);
		assertEquals(g,linkedCar.getLast());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("How", linkedString.getFirst());
		linkedString.addToFront("Farnaz");
		assertEquals("Farnaz", linkedString.getFirst());
		
		assertEquals(a,linkedCar.getFirst());
		linkedCar.addToFront(f);
		assertEquals(f,linkedCar.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals((Double)15.0, linkedDouble.getFirst());
		linkedDouble.addToFront(1234.0);
		assertEquals((Double)1234.0, linkedDouble.getFirst());
		
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		
		assertEquals(a,linkedCar.getFirst());
		linkedCar.addToFront(g);
		assertEquals(g,linkedCar.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("Doing", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		
		assertEquals(d,linkedCar.getLast());
		linkedCar.addToEnd(a);
		assertEquals(a,linkedCar.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<Car> list;
		linkedCar.addToFront(f);
		linkedCar.addToEnd(g);
		list = linkedCar.toArrayList();
		assertEquals(f,list.get(0));
		assertEquals(a,list.get(1));
		assertEquals(b,list.get(2));
		assertEquals(c,list.get(3));
		assertEquals(d,list.get(4));
		assertEquals(g,list.get(5));
		
		ArrayList<String> list2;
		linkedString.addToFront("Farshad");
		linkedString.addToEnd("Farinaz");
		list2 = linkedString.toArrayList();
		assertEquals((String)"Farshad",list2.get(0));
		assertEquals((String)"How",list2.get(1));
		assertEquals((String)"Are",list2.get(2));
		assertEquals((String)"You",list2.get(3));
		assertEquals((String)"What",list2.get(4));
		assertEquals((String)"Doing",list2.get(5));
		assertEquals((String)"Farinaz",list2.get(6));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("How", iterator.next());
		assertEquals("Are", iterator.next());
		assertEquals("You", iterator.next());
		assertEquals("What", iterator.next());
		assertEquals("Doing", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
		
		linkedCar.addToFront(e);
		linkedCar.addToEnd(g);
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(e, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(g, iteratorCar.next());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedCar.addToFront(f);
		linkedCar.addToEnd(h);
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(f, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(h, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(h, iteratorCar.previous());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
		assertEquals(f, iteratorCar.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		
		try{
			//no more elements in list
			iteratorCar.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedCar.addToFront(g);
		linkedCar.addToEnd(h);
		ListIterator<Car> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(g, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(a, iteratorCar.previous());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(h, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(h, iteratorCar.previous());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
		assertEquals(g, iteratorCar.previous());
		try{
			//no more elements in list
			iteratorCar.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedCar.addToFront(e);
		linkedCar.addToEnd(f);
		ListIterator<Car> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(e, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(f, iteratorCar.next());
		
		try{
			//remove is not supported for the iterator
			iteratorCar.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	@Test
	public void testRemove() {
		// remove the first
		assertEquals(a, linkedCar.getFirst());
		assertEquals(d, linkedCar.getLast());
		linkedCar.addToFront(h);
		assertEquals(h, linkedCar.getFirst());
		linkedCar.remove(h, comparatorCar);
		assertEquals(a, linkedCar.getFirst());
		//remove from the end of the list
		linkedCar.addToEnd(e);
		assertEquals(e, linkedCar.getLast());
		linkedCar.remove(e, comparatorCar);
		assertEquals(d, linkedCar.getLast());
		//remove from middle of list
		linkedCar.addToFront(h);
		assertEquals(h, linkedCar.getFirst());
		assertEquals(d, linkedCar.getLast());
		linkedCar.remove(b, comparatorCar);
		assertEquals(h, linkedCar.getFirst());
		assertEquals(d, linkedCar.getLast());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals(a, linkedCar.getFirst());
		linkedCar.addToFront(h);
		assertEquals(h, linkedCar.getFirst());
		assertEquals(h, linkedCar.retrieveFirstElement());
		assertEquals(a,linkedCar.getFirst());
		assertEquals(a, linkedCar.retrieveFirstElement());
		assertEquals(b,linkedCar.getFirst());
		
		assertEquals("How", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		assertEquals("New", linkedString.retrieveFirstElement());
		assertEquals("How",linkedString.getFirst());
		assertEquals("How", linkedString.retrieveFirstElement());
		assertEquals("Are",linkedString.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(d, linkedCar.getLast());
		linkedCar.addToEnd(e);
		assertEquals(e, linkedCar.getLast());
		assertEquals(e, linkedCar.retrieveLastElement());
		assertEquals(d,linkedCar.getLast());
		
		assertEquals("Doing", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		assertEquals("New", linkedString.retrieveLastElement());
		assertEquals("Doing",linkedString.getLast());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class CarComparator implements Comparator<Car>
	{

		@Override
		public int compare(Car arg0, Car arg1) {
			// Just put cars in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Car{
		String make;
		String model;
		int year;
		
		public Car(String make, String model, int year){
			this.make = make;
			this.model = model;
			this.year = year;
		}
		
		public String getMake(){
			return make;
		}
		public String getModel(){
			return model;
		}
		public int getYear(){
			return year;
		}
		
		public String toString() {
			return (getMake()+" "+getModel()+" "+getYear());
		}
	}
}
