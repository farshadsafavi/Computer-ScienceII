


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Town_STUDENT_TEST {
	private Town[] town;

	@Before
	public void setUp() throws Exception {
		  town = new Town[3];
		  
		  for (int i = 0; i < 3; i++) {
			  town[i] = new Town("Town_" + i);
		  }
		  town[0].addEdge(town[1], 5);
		  town[0].addEdge(town[2], 3);
		  town[1].addEdge(town[2], 8);
		  town[2].addEdge(town[0], 18);
		  town[2].addEdge(town[1], 20);
		  
	}

	@After
	public void tearDown() throws Exception {
		for (int i = 0; i < 3; i++) {
			  town[i] = null;
		}
	}

	@Test
	public void testGetName() {
		assertEquals("Town_0",town[0].getName());
		assertEquals("Town_1",town[1].getName());
		assertEquals("Town_2",town[2].getName());
	}
	
	@Test
	public void testGetAdjacentListKeys() {
		ArrayList<String> arr = new ArrayList<String>();
		for (Town i : town[0].getAdjacentKeys()){
			arr.add(i.getName());
		}
		ArrayList<String> test = new ArrayList<String>();
		test.add("Town_2");
		test.add("Town_1");
		assertEquals(test, arr);
	}
	
	@Test
	public void testGetAdjacentListValues() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (Integer i : town[1].getAdjacentWeights()){
			arr.add(i);
		}
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(8);
		assertEquals(test, arr);
	}

}
