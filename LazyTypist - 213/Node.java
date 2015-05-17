import java.util.ArrayList;

/**
 * Created by Dustin on 5/17/15.
 * This node class is used to represent keys on a keyboard.
 */
public class Node {

    public final char key;

    public Node(char key){
        this.key = key;
    }

    public ArrayList<Character> edgeList = new ArrayList<Character>();

    /**
     * Adds a non-directional edge between the current node and the destination node
     * @param destination Destination node for the edge
     */
    public void addEdge(char destination){
        edgeList.add(destination);
    }
}
