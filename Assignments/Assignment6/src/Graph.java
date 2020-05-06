import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road>{
	
    private Set<Town> towns;
    private Set<Road> roads;
    // default constructor implementation
    public Graph()
    {
       towns = new HashSet<Town>();
       roads = new HashSet<Road>();
    }
    
    public Set<Road> getRoads(){
    	return roads;
    }
    
    public Set<Town> getTowns(){
    	return towns;
    }
    
    public void setTowns(Set<Town> t){
    	towns = t;
    }
    
    public void setRoads(Set<Road> roads2){
    	roads = roads2;
    }

	@Override
	public Road getEdge(Town src, Town dest) {
		for (Road road : roads)
	       {
	           if (( road.getSource().equals(src) &&  road.getDestination().equals(dest)) || 
	               ( road.getDestination().equals(src) &&  road.getSource().equals(dest))){
	               return road;
	           }
	       }
	      
	       return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road newRoad = new Road(sourceVertex,destinationVertex,weight, description);
		roads.add(newRoad);
		sourceVertex.addEdge(destinationVertex, weight);
		destinationVertex.addEdge(sourceVertex, weight);
		return newRoad;
	}

	@Override
	public boolean addVertex(Town v) {
//		System.out.println(v);
		return towns.add(v);
	}

	@Override
	public boolean containsEdge(Town source, Town destination) {
		
       for (Road road : roads)
       {
    	   if (road.contains(source) && road.contains(destination))
               return true;

       }
       return false;
	}

	@Override
	public boolean containsVertex(Town t) {
		 for (Town town : towns){
	           if (t.compareTo(town) == 0){
	               return true;
	           }
         }
	     return false;
	}

	@Override
	public Set<Road> edgeSet() {
		return roads;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
       Set<Road> res = new HashSet<Road>();
       for (Road road : this.roads)
       {
           if (road.contains(vertex))
               res.add(road);
       }
       return res;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String name) {
		Road removed = null;
		for (Road road : roads)
	       {
	           if (road.getSource() == sourceVertex && 
	        	   road.getDestination() == destinationVertex && 
	        	   road.getName() == name){
	               removed = road;
	           }
	       }
		roads.remove(removed);
		return removed;
	}

	@Override
	public boolean removeVertex(Town v) {
		try{
			towns.remove(v);
		}
		catch(NullPointerException e){
			return false;
		}

		return true;
	}

	@Override
	public Set<Town> vertexSet() {
		Set<Town> hs = new HashSet<Town>();
		for(Town a : towns)
			hs.add(a);
		return hs;
	}

	   // shortestPath method implementation
	   @Override
	   public ArrayList<String> shortestPath(Town sv, Town dv)
	   {
	       dijkstraShortestPath(sv);
	       
	       ArrayList<String> sp = new ArrayList<String>();
	       LinkedList<Town> listOfTowns = dv.getShortestPath();
	       
	       Town reserve = null;
	       Road r= null;
	       int dist = 0;
	       if(listOfTowns.size() == 0) return null;
	       for (int i = 0; i < listOfTowns.size(); i++)
	       {
	    	   if (i != 0){
	    		   r = getEdge(reserve, listOfTowns.get(i));
	    		   int final_dist = listOfTowns.get(i).getDistance() - dist;
	    		   sp.add(reserve.getName() + " via " + r.getName() + " to " + listOfTowns.get(i).getName() + " " + final_dist + " mi");
	    	   }
	    	   reserve = listOfTowns.get(i);
	    	   dist = listOfTowns.get(i).getDistance();
	       }
	       int final_dist = dv.getDistance() - dist;
	       r = getEdge(reserve, dv);
	       if (!sp.isEmpty())
	    	   sp.add(reserve.getName() + " via " + r.getName() + " to " + dv.getName() + " " + final_dist + " mi");
	      
	       return sp;
	   }

	   // dijkstraShortestPath method implementation
	   @Override
	   public void dijkstraShortestPath(Town sv)
	   {
	       sv.setDistance(0);
	       Set<Town> setOfTowns1 = new HashSet<>();
	       Set<Town> setOfTowns2 = new HashSet<>();
	       setOfTowns2.add(sv);

	       while (setOfTowns2.size() != 0)
	       {
	           Town currentTown = getLowestDistanceTown(setOfTowns2);
	           setOfTowns2.remove(currentTown);

	           for (Entry<Town, Integer> entry : currentTown.getAdjacentList().entrySet())
	           {
	               Town adjTown = entry.getKey();
	               Integer edgedistance = entry.getValue();

	               if (!setOfTowns1.contains(adjTown))
	               {
	                   findMinDistance(adjTown, edgedistance, currentTown);
	                   setOfTowns2.add(adjTown);
	               }
	           }
	           setOfTowns1.add(currentTown);
	       }
	   }

	   // getLowestDistanceTown method implementation
	   private static Town getLowestDistanceTown(Set<Town> setOfTowns)
	   {
	       Town lowDistanceTown = null;
	       int lowDistance = Integer.MAX_VALUE;
	       for (Town town : setOfTowns)
	       {
	           int townDistance = town.getDistance();
	           if (townDistance < lowDistance)
	           {
	               lowDistance = townDistance;
	               lowDistanceTown = town;
	           }
	       }
	       return lowDistanceTown;
	   }

	   // findMinDistance method implementation
	   private static void findMinDistance(Town evaluationTown, Integer edgeWeigh, Town sourceTown)
	   {
	       Integer sourceTownDistance = sourceTown.getDistance();
	       if (sourceTownDistance + edgeWeigh < evaluationTown.getDistance())
	       {
	           evaluationTown.setDistance(sourceTownDistance + edgeWeigh);
	           LinkedList<Town> sp = new LinkedList<>(sourceTown.getShortestPath());
	           sp.add(sourceTown);
	           evaluationTown.setShortestPath(sp);
	       }
	   }

}
