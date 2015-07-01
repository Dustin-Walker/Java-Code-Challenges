import java.util.ArrayList;

/**
 * Created by Dustin Walker.
 * This class represents a street intersection and a node in a graph.
 * Intersections/nodes are connected by streets/edges.
 */
public class Intersection{

    private ArrayList<Street> connections = new ArrayList<Street>();
    public String name = "undefined";
    public int shortestPathEstimate;
    public Intersection predecessor;

    public ArrayList<Street> getConnections() {
        return connections;
    }

    public void addConnection(Street street){
        connections.add(street);
    }

    public Intersection(String name){
        this.name = name;
    }
}