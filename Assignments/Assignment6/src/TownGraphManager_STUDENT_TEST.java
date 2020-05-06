


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownGraphManager_STUDENT_TEST {
	private TownGraphManagerInterface graph;
	private String[] town;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town = new String[8];
		  
		  for (int i = 1; i < 8; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  graph.addRoad(town[1], town[2], 2, "Road_1");
		  graph.addRoad(town[1], town[3], 4, "Road_2");
		  graph.addRoad(town[2], town[3], 1, "Road_3");
		  graph.addRoad(town[2], town[4], 7, "Road_4");
		  graph.addRoad(town[3], town[5], 3, "Road_5");
		  graph.addRoad(town[5], town[4], 2, "Road_6");
		  graph.addRoad(town[4], town[6], 1, "Road_7");
		  graph.addRoad(town[5], town[6], 5, "Road_8");
		 
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}
	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_2", roads.get(1));
		assertEquals("Road_3", roads.get(2));
		assertEquals("Road_4", roads.get(3));
		graph.addRoad(town[3], town[4], 1,"Road_8");
		roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_2", roads.get(1));
		assertEquals("Road_3", roads.get(2));
		assertEquals("Road_4", roads.get(3));
		assertEquals("Road_8", roads.get(7));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("Road_4", graph.getRoad(town[2], town[4]));
		assertEquals("Road_8", graph.getRoad(town[5], town[6]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, graph.containsTown("Town_8"));
		graph.addTown("Town_8");
		assertEquals(true, graph.containsTown("Town_8"));
	}
	
	@Test
	public void testDisjointGraph() {
		assertEquals(false, graph.containsTown("Town_12"));
		graph.addTown("Town_12");
		ArrayList<String> path = graph.getPath(town[1],"Town_12");
		assertFalse(path.size() > 0);
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, graph.containsTown("Town_2"));
		assertEquals(false, graph.containsTown("Town_12"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[2], town[4]));
		assertEquals(false, graph.containsRoadConnection(town[3], town[4]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_2", roads.get(1));
		assertEquals("Road_3", roads.get(2));
		assertEquals("Road_4", roads.get(3));
		assertEquals("Road_5", roads.get(4));
	}
	
	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[5], town[6]));
		graph.deleteRoadConnection(town[5], town[6], "Road_8");
		assertEquals(false, graph.containsRoadConnection(town[5], town[6]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, graph.containsTown("Town_1"));
		graph.deleteTown(town[1]);
		assertEquals(false, graph.containsTown("Town_1"));
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = graph.allTowns();
		assertEquals("Town_1", roads.get(0));
		assertEquals("Town_2", roads.get(1));
		assertEquals("Town_3", roads.get(2));
		assertEquals("Town_4", roads.get(3));
		assertEquals("Town_7", roads.get(6));
	}
	@Test
	public void testGetPath() {
		ArrayList<String> path = graph.getPath(town[1],town[5]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_1 to Town_2 2 mi",path.get(0).trim());
		  assertEquals("Town_2 via Road_3 to Town_3 1 mi",path.get(1).trim());
		  assertEquals("Town_3 via Road_5 to Town_5 3 mi",path.get(2).trim());

	}
	
	@Test
	public void testGetPathA() {
		ArrayList<String> path = graph.getPath(town[1],town[6]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_1 to Town_2 2 mi",path.get(0).trim());
		  assertEquals("Town_2 via Road_3 to Town_3 1 mi",path.get(1).trim());
		  assertEquals("Town_3 via Road_5 to Town_5 3 mi",path.get(2).trim());
		  assertEquals("Town_5 via Road_6 to Town_4 2 mi",path.get(3).trim());
		  assertEquals("Town_4 via Road_7 to Town_6 1 mi",path.get(4).trim());
	}
	
	
}
