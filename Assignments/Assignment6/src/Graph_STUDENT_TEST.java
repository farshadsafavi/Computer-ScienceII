


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Graph_STUDENT_TEST {
	private GraphInterface<Town,Road> graph;
	private Town[] town;

	@Before
	public void setUp() throws Exception {
		  graph = new Graph();
		  town = new Town[8];
		  
		  for (int i = 1; i < 8; i++) {
			  town[i] = new Town("Town_" + i);
			  graph.addVertex(town[i]);
		  }
		  
		  graph.addEdge(town[1], town[2], 2, "Road_1");
		  graph.addEdge(town[1], town[3], 4, "Road_2");
		  graph.addEdge(town[2], town[3], 1, "Road_3");
		  graph.addEdge(town[2], town[4], 7, "Road_4");
		  graph.addEdge(town[3], town[5], 3, "Road_5");
		  graph.addEdge(town[5], town[4], 2, "Road_6");
		  graph.addEdge(town[4], town[6], 1, "Road_7");
		  graph.addEdge(town[5], town[6], 5, "Road_8");
		  
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testGetEdge() {
		assertEquals(new Road(town[1], town[3],4, "Road_2"), graph.getEdge(town[1], town[3]));
		assertEquals(new Road(town[3], town[5],3, "Road_5"), graph.getEdge(town[3], town[5]));
	}

	@Test
	public void testAddEdge() {
		assertEquals(false, graph.containsEdge(town[3], town[4]));
		graph.addEdge(town[3], town[4], 1, "Road_8");
		assertEquals(true, graph.containsEdge(town[3], town[4]));
	}

	@Test
	public void testAddVertex() {
		Town newTown = new Town("Town_12");
		assertEquals(false, graph.containsVertex(newTown));
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
	}

	@Test
	public void testContainsEdge() {
		assertEquals(true, graph.containsEdge(town[4], town[6]));
		assertEquals(false, graph.containsEdge(town[2], town[5]));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, graph.containsVertex(new Town("Town_2")));
		assertEquals(false, graph.containsVertex(new Town("Town_12")));
	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
		assertEquals("Road_2", roadArrayList.get(1));
		assertEquals("Road_3", roadArrayList.get(2));
		assertEquals("Road_4", roadArrayList.get(3));
		assertEquals("Road_5", roadArrayList.get(4));
		assertEquals("Road_7", roadArrayList.get(6));
	}

	@Test
	public void testEdgesOf() {
		Set<Road> roads = graph.edgesOf(town[1]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
		assertEquals("Road_2", roadArrayList.get(1));
	}
	
	@Test
	public void testRemoveEdge() {
		assertEquals(true, graph.containsEdge(town[4], town[6]));
		graph.removeEdge(town[4], town[6], 1, "Road_7");
		assertEquals(false, graph.containsEdge(town[4], town[6]));
	}
	
	@Test
	public void testRemoveVertex() {
		assertEquals(true, graph.containsVertex(town[2]));
		graph.removeVertex(town[2]);
		assertEquals(false, graph.containsVertex(town[2]));
	}

	@Test
	public void testVertexSet() {
		Set<Town> roads = graph.vertexSet();
		assertEquals(true,roads.contains(town[1]));
		assertEquals(true, roads.contains(town[6]));
		assertEquals(true, roads.contains(town[5]));
		assertEquals(true, roads.contains(town[2]));
		assertEquals(true, roads.contains(town[3]));
	}

	 @Test
	  public void testTown_1ToTown_6() {
		  String beginTown = "Town_1", endTown = "Town_6";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_1 via Road_1 to Town_2 2 mi",path.get(0).trim());
			  assertEquals("Town_2 via Road_3 to Town_3 1 mi",path.get(1).trim());
			  assertEquals("Town_3 via Road_5 to Town_5 3 mi",path.get(2).trim());
			  assertEquals("Town_5 via Road_6 to Town_4 2 mi",path.get(3).trim());
			  assertEquals("Town_4 via Road_7 to Town_6 1 mi",path.get(4).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  
	  @Test
	  public void testTown1ToTown_4() {
		  String beginTown = "Town_1", endTown = "Town_4";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_1 via Road_1 to Town_2 2 mi",path.get(0).trim());
			  assertEquals("Town_2 via Road_3 to Town_3 1 mi",path.get(1).trim());
			  assertEquals("Town_3 via Road_5 to Town_5 3 mi",path.get(2).trim());
			  assertEquals("Town_5 via Road_6 to Town_4 2 mi",path.get(3).trim());
		  }
		  else
			  fail("Town names are not valid");
	  }
	  
	  
}
