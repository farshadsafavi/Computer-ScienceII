

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SortedDoubleLinkedList_STUDENT_Test {
	SortedDoubleLinkedList<String> linkedString;
	SortedDoubleLinkedList<Double> linkedDouble;
	SortedDoubleLinkedList<Car> linkedCar;
	StringComparator comparator;
	DoubleComparator comparatorD;
	CarComparator comparatorCar;
	
	public Car a=new Car("Ford", "F150", 2005);
	public Car b=new Car("Jeep", "Renegade", 2005);
	public Car c=new Car("Honda", "Civic", 2005);
	public Car d=new Car("Subaru", "Outback", 2005);
	public Car e=new Car("Chevrolet", "Silverado", 2005);
	public Car f=new Car("Chrysler", "PTCruiser", 2005);
	public Car g=new Car("Peride", "hachback", 2005);
	public Car h=new Car("Peikan", "Renegade", 2005);
	public Car i=new Car("WWW", "Test", 2005);
	public Car j=new Car("AAA", "Test", 2005);
	
	public ArrayList<Car> fill = new ArrayList<Car>();
	

	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		linkedString = new SortedDoubleLinkedList<String>(comparator);
		linkedString.add("How");
		linkedString.add("Are");
		linkedString.add("You");
		linkedString.add("What");
		linkedString.add("Doing");
		linkedString.add("Baby");
		
		comparatorD = new DoubleComparator();
		linkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		linkedDouble.add(15.0);
		linkedDouble.add(100.0);
		linkedDouble.add(1.0);
		linkedDouble.add(200.0);
		
		comparatorCar = new CarComparator();
		linkedCar= new SortedDoubleLinkedList<Car>(comparatorCar);
		linkedCar.add(a);
		linkedCar.add(b);
		linkedCar.add(c);
		linkedCar.add(d);
		linkedCar.add(e);
		linkedCar.add(f);
		
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
		assertEquals(6,linkedString.getSize());
		assertEquals(4,linkedDouble.getSize());
		assertEquals(6,linkedCar.getSize());
	}
	
	@Test
	public void testAdd() {
		assertEquals("You", linkedString.getLast());
		linkedString.add("AAA");
		assertEquals("AAA", linkedString.getFirst());
		
		assertEquals(d,linkedCar.getLast());
		linkedCar.add(i);
		assertEquals(i,linkedCar.getLast());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals((Double)1.0, linkedDouble.getFirst());
		linkedDouble.add(0.0);
		assertEquals((Double)0.0, linkedDouble.getFirst());
		
		linkedString.add("AAA");
		assertEquals("AAA", linkedString.getFirst());
		
		assertEquals(e,linkedCar.getFirst());
		linkedCar.add(j);
		assertEquals(j,linkedCar.getFirst());
	}
	
	@Test
	public void testGetLast() {
		assertEquals("You", linkedString.getLast());
		linkedString.add("ZZZ");
		assertEquals("ZZZ", linkedString.getLast());
		
		assertEquals(d,linkedCar.getLast());
		linkedCar.add(i);
		assertEquals(i,linkedCar.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<Car> list;
		linkedCar.add(g);
		list = linkedCar.toArrayList();
		assertEquals(e,list.get(0));
		assertEquals(f,list.get(1));
		assertEquals(a,list.get(2));
		assertEquals(c,list.get(3));
		assertEquals(b,list.get(4));
		assertEquals(g,list.get(5));
		assertEquals(d,list.get(6));
		
		ArrayList<String> list2;
		linkedString.add("Farshad");
		linkedString.add("Farinaz");
		list2 = linkedString.toArrayList();
		assertEquals((String)"Are",list2.get(0));
		assertEquals((String)"Baby",list2.get(1));
		assertEquals((String)"Doing",list2.get(2));
		assertEquals((String)"Farinaz",list2.get(3));
		assertEquals((String)"Farshad",list2.get(4));
		assertEquals((String)"How",list2.get(5));
		assertEquals((String)"What",list2.get(6));
		assertEquals((String)"You",list2.get(7));
		
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.add("Farshad");
		linkedString.add("Farinaz");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Are", iterator.next());
		assertEquals("Baby", iterator.next());
		assertEquals("Doing", iterator.next());
		assertEquals("Farinaz", iterator.next());
		assertEquals("Farshad", iterator.next());
		assertEquals("How", iterator.next());
		assertEquals("What", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("You", iterator.next());
		
		linkedCar.add(g);
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(e, iteratorCar.next());
		assertEquals(f, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(g, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedCar.add(g);
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(e, iteratorCar.next());
		assertEquals(f, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(g, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(g, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
		assertEquals(f, iteratorCar.previous());
		assertEquals(e, iteratorCar.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedCar.add(g);
		ListIterator<Car> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(e, iteratorCar.next());
		assertEquals(f, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(g, iteratorCar.next());
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
		linkedCar.add(g);
		ListIterator<Car> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(e, iteratorCar.next());
		assertEquals(f, iteratorCar.next());
		assertEquals(f, iteratorCar.previous());
		assertEquals(f, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(g, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(g, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
		assertEquals(f, iteratorCar.previous());
		assertEquals(e, iteratorCar.previous());
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
		linkedCar.add(g);
		ListIterator<Car> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(e, iteratorCar.next());
		assertEquals(f, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(c, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(g, iteratorCar.next());
		
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
		assertEquals(e, linkedCar.getFirst());
		assertEquals(d, linkedCar.getLast());
		linkedCar.add(j);
		assertEquals(j, linkedCar.getFirst());
		linkedCar.remove(j, comparatorCar);
		assertEquals(e, linkedCar.getFirst());
		//remove from the end of the list
		linkedCar.add(i);
		assertEquals(i, linkedCar.getLast());
		linkedCar.remove(i, comparatorCar);
		assertEquals(d, linkedCar.getLast());
		//remove from middle of list
		linkedCar.add(h);
		assertEquals(e, linkedCar.getFirst());
		assertEquals(d, linkedCar.getLast());
		linkedCar.remove(h, comparatorCar);
		assertEquals(e, linkedCar.getFirst());
		assertEquals(d, linkedCar.getLast());
		
	}

	
	@Test
	public void testRetrieveFirstElement() {
		assertEquals(e, linkedCar.getFirst());
		linkedCar.add(j);
		assertEquals(j, linkedCar.getFirst());
		assertEquals(j, linkedCar.retrieveFirstElement());
		assertEquals(e,linkedCar.getFirst());
		assertEquals(e, linkedCar.retrieveFirstElement());
		assertEquals(f,linkedCar.getFirst());
		
		assertEquals("Are", linkedString.getFirst());
		linkedString.add("WWW");
		assertEquals("Are", linkedString.getFirst());
		assertEquals("Are", linkedString.retrieveFirstElement());
		assertEquals("Baby",linkedString.getFirst());
		assertEquals("Baby", linkedString.retrieveFirstElement());
		assertEquals("Doing",linkedString.getFirst());
		
	}
	
	@Test
	public void testRetrieveLastElement() {
		assertEquals(d, linkedCar.getLast());
		linkedCar.add(i);
		assertEquals(i, linkedCar.getLast());
		assertEquals(i, linkedCar.retrieveLastElement());
		assertEquals(d,linkedCar.getLast());
		
		assertEquals("You", linkedString.getLast());
		linkedString.add("ZZZ");
		assertEquals("ZZZ", linkedString.getLast());
		assertEquals("ZZZ", linkedString.retrieveLastElement());
		assertEquals("You",linkedString.getLast());
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
