import java.util.Hashtable;

/**
 * Created by Dustin on 5/17/15.
 * This node class is used to represent keys on a keyboard.
 */
public class Node {

    public final String key;

    public Node(String key){
        this.key = key;
    }

    public Hashtable<Character, Character> edgeList = new Hashtable<Character, Character>();

    public String printEdgeList(){
        String s = "";
        for(char c : edgeList.values()){
            s = s.concat(c+" ");
        }
        return s;
    }


    /**
     * Adds a non-directional edge between the current node and the destination node
     * @param destination Destination node for the edge
     */
    public void addEdge(char destination){
        edgeList.put(destination, destination);
    }
}