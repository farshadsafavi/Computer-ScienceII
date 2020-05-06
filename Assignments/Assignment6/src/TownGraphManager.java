import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class TownGraphManager implements TownGraphManagerInterface{
	private Graph graph;
	public TownGraphManager(){
		graph = new Graph();
	}

	public ArrayList<String> allTowns() {
		ArrayList<String> output = new ArrayList<String>();
		Set<Town> vertices = graph.vertexSet();
		for(Town a: vertices){
			output.add((String) a.getName());
		}
		Collections.sort(output);
		return output;
	}

	public ArrayList<String> allRoads() {
		ArrayList<String> array = new ArrayList<String>();
		Set<Road> edges = graph.getRoads();
		for(Road e: edges){
			array.add(e.getName());
		}
		Collections.sort(array);
		return array;
	}

	public Town getTown(String string) {
	       return null;
	}

	
	@Override
	public String getRoad(String town1, String town2) {
		Town source = null;
	    Town dest = null;
	    Set<Town> towns = graph.getTowns();
	    Set<Road> roads = graph.getRoads();
	    for(Town t:towns){
           if(t.equals(new Town(town1)))
           {
               source = t;
           }
           if(t.equals(new Town(town2)))
           {
        	   dest= t;
           }
	    }
	       
	    for (Road road : roads)
	       {
	           if (((road.getSource().compareTo(source) == 0) && (road.getDestination().compareTo(dest) == 0))
	                   || ((road.getDestination().compareTo(source) == 0)
	                           && (road.getSource().compareTo(dest) == 0)))
	           {
	               return road.getName();
	           }
	       } 
	      
	    return null;
	}

	@Override
	public boolean addTown(String v) {
		Town t = new Town(v);
//		System.out.println(v);
		return graph.addVertex(t);
	}

	@Override
	public boolean containsTown(String v) {
		Town t = new Town(v);
		return graph.containsVertex(t);
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town source = null;
	    Town dest = null;
	    Set<Town> towns = graph.getTowns();
	    Set<Road> roads = graph.getRoads();
	    for(Town t:towns){
           if(t.equals(new Town(town1)))
           {
               source = t;
           }
           if(t.equals(new Town(town2)))
           {
        	   dest= t;
           }
	    }
	       
	    for (Road road : roads)
	       {
	        if (road.contains(source) && road.contains(dest))
	               return true;
	       } 
	      
	    return false;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		 Town source = null;
	     Town dest = null;
	     Set<Town> towns = graph.getTowns();
	     Set<Road> roads = graph.getRoads();
	     for(Town t:towns){
           if(t.equals(new Town(town1)))
           {
               source = t;
           }
           if(t.equals(new Town(town2)))
           {
        	   dest= t;
           }
	    }
	     Road ro = null;
	     for (Road r : roads){
		     if(r.getName().equals(road)){
		    	 ro = r;
		     }
	     }
	       boolean a = roads.remove(ro);
	       graph.removeEdge(source, dest, ro.getWeight(), road);
	       return a; 
	}

	@Override
	public boolean deleteTown(String v) {
		return graph.removeVertex(new Town(v));
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
	     Town source = null;
	     Town dest = null;
	     Set<Town> towns = graph.getTowns();
	     System.out.println(towns);
	     for(Town t:towns){
          if(t.getName().equals(town1))
          {
              source = t;
          }
          if(t.getName().equals(town2))
          {
       	      dest= t;
          }
	    }
	     if (graph.shortestPath(source,dest) == null){
	    	 return new ArrayList<String>(10);
	     }
        return graph.shortestPath(source,dest);
	}


	@Override
	public boolean addRoad(String name, String name2, int weight, String name3) {
		Town source = null;
	     Town dest = null;
	     Set<Town> towns = graph.getTowns();
	     for(Town t:towns){
	         if(t.getName().equals(name))
	         {
	             source = t;
	         }
	         if(t.getName().equals(name2))
	         {
	      	      dest= t;
	         }
	    }
	     graph.addEdge(source, dest, weight, name3);
	     return true;
	}

	public void populateTownGraph(File selectedFile) {
		// TODO Auto-generated method stub
		
	}

	

}
