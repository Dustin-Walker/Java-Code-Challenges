import java.util.HashMap;

/**
 * Created by Dustin on 5/17/15.
 * This graph represents a keyboard where the nodes are keys and the edges describe which keys are adjacent
 * to each other.
 */
public class Graph {

    HashMap<Character, Node> nodeCollection = new HashMap<Character, Node>();

    public void addNode(Node node){

        nodeCollection.put(node.key, node);

    }

}
