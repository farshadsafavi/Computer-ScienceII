


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Road_STUDENT_TEST {
	private Town[] town;
	private Road[] road;
	@Before
	public void setUp() throws Exception {
		  town = new Town[3];
		  road = new Road[5];
		  for (int i = 0; i < 3; i++) {
			  town[i] = new Town("Town_" + i);
		  }
		  
		  town[0].addEdge(town[1], 5);
		  town[0].addEdge(town[2], 3);
		  town[1].addEdge(town[2], 8);
		  town[2].addEdge(town[0], 18);
		  town[2].addEdge(town[1], 20);
		  
		  road[0] = new Road(town[0], town[1], 5, "road_1");
		  road[1] = new Road(town[0], town[2], 3, "road_2");
		  road[2] = new Road(town[1], town[2], 8, "road_3");
		  road[3] = new Road(town[2], town[0], 18, "road_4");
		  road[4] = new Road(town[2], town[1], 20, "road_5");
	}

	@After
	public void tearDown() throws Exception {
		for (int i = 0; i < 3; i++) {
			  town[i] = null;
		}
		
		for (int i = 0; i < 5; i++) {
			  road[i] = null;
		 }
	}

	@Test
	public void testGetName() {
		assertEquals("road_1",road[0].getName());
		assertEquals("road_2",road[1].getName());
		assertEquals("road_3",road[2].getName());
		assertEquals("road_4",road[3].getName());
		assertEquals("road_5",road[4].getName());
	}
	
	@Test
	public void testContains() {
		assertTrue(road[0].contains(town[0]));
		assertTrue(road[0].contains(town[1]));
		assertTrue(road[1].contains(town[2]));
		assertTrue(road[1].contains(town[0]));
		assertTrue(road[4].contains(town[2]));
	}
	
	@Test
	public void testEquals() {
		assertFalse(road[0].equals(road[1]));
		assertFalse(road[1].equals(road[2]));
		assertFalse(road[2].equals(road[3]));
		assertFalse(road[3].equals(road[4]));
		assertFalse(road[0].equals(road[3]));
	}

}
