
public class Road implements Comparable<Road>{
	private Town source;
	private Town destination;
	private int distance;
	private String name;
	public Road(Town source,
            	Town destination,
            	int distance,
            	String name){
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.name = name;
	}
	
	public Road(Town source,
        	Town destination,
        	String name){
		this.source = source;
		this.destination = destination;
		this.name = name;
    }
	public boolean contains(Town town){
		return town.equals(source) || town.equals(destination) ;
		
	}
	
	public String getName() {
		return this.name;
	}
	  
	   
    public int getDistance()
    {
       return distance;
    }
	
	public String toString(){
		return this.name + ":" + distance + " from " + source.toString() + " to"  + destination.toString();
	}
	
	public Town getDestination(){
		return destination;
	}
	
	public Town getSource(){
		return source;
	}
	
	@Override
	public int compareTo(Road other){
		if (this.distance < (other.distance))
        	return -1;
		else if (this.distance > (other.distance))
			return 1;
		else
			return 0;
	}
	
	public int getWeight(){
		return distance;
	}
	
	@Override
	public boolean equals(Object o){
		// self check
	    if (this == o)
	        return true;
	    // null check
	    if (o == null)
	        return false;
	    // type check and cast
	    if (getClass() != o.getClass())
	        return false;
	    Road road = (Road) o;
	    // field comparison
	    return (road.getSource().equals(this.source)
	            && road.getDestination().equals(this.destination)) ||
	            (road.getDestination().equals(this.source)
	            && road.getSource().equals(this.destination));
	}
	

}
