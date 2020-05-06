import java.awt.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Town implements Comparable<Town> {
	private String name;
	private Map<Town, Integer> adjacentList;
	// Fields for finding shortest path problems
	private LinkedList<Town> shortestPath;
	private Integer distance;
   
	public Town(String name) {
		super();
		this.name = name;
        this.adjacentList = new HashMap<Town, Integer>();
        this.shortestPath = new LinkedList<Town>();
        this.distance = Integer.MAX_VALUE;
	}
	
   // getter for the data field adjacentList
   public Map<Town, Integer> getAdjacentList()
   {
       return adjacentList;
   }
   
   public Collection<Integer> getAdjacentWeights()
   {
       return adjacentList.values();
   }
   
   public Set<Town> getAdjacentKeys()
   {
       return adjacentList.keySet();
   }

   public void addEdge(Town destination, int distance){
	   Town key = destination;
	   int value = distance;
	   adjacentList.put(key, value);
   }
   

	public String getName() {
		return this.name;
	}
	
    public void setName(String name)
    {
       this.name = name;
    }
    
    @Override
    public String toString()
    {
        return name + ":" + adjacentList.values();
    }

	@Override
	public int compareTo(Town t) {
		String thisTown = this.getName().toLowerCase();
		return thisTown.compareTo(t.name.toLowerCase());
	}
	
    //Depends only on Town name
    @Override
    public int hashCode() {
        return name.hashCode();
    }
 
    //Compare Towns
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Town other = (Town) obj;
        if (name != other.name)
            return false;
        return true;
    }  
    
    // Shortest Problem Features
    public LinkedList<Town> getShortestPath()
    {
        return shortestPath;
    }
    
    public void setDistance(int distance)
    {
        this.distance = distance;
    }

    public int getDistance()
    {
        return distance;
    }

	public void setShortestPath(LinkedList<Town> sp) {
		 this.shortestPath = new LinkedList<Town>(sp);
	}

    
}
