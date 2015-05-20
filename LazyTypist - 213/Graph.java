import java.util.HashMap;

/**
 * Created by Dustin on 5/17/15.
 * This graph represents a keyboard where the nodes are keys and the edges describe which keys are adjacent
 * to each other.
 */
public class Graph {

    public Graph(String[] keyboardString){
        keyboardToGraph(keyboardString);
    }

    public Graph(){}

    public HashMap<Character, Node> nodeCollection = new HashMap<Character, Node>();

    public void addNode(Node node){

        nodeCollection.put(node.key, node);

    }

    /**
     * Converts a keyboard layout into a graph
     * @param keyboard String array where each string element represents a line on the keyboard
     * @return Populated graph containing keys as nodes
     */
    public Graph keyboardToGraph(String[] keyboard){
        int keyboardRows = keyboard.length;
        Graph g = new Graph();
        for (int i = 0; i < keyboardRows; i++) {
            int keyboardRowLength = keyboard[i].length();
            for (int j = 0; j < keyboardRowLength; j++) {
                g.addNode(new Node(keyboard[i].charAt(j)));

                // Add edge to node on the left side
                if(j > 0)
                    g.nodeCollection.get(keyboard[i].charAt(j)).addEdge(keyboard[i].charAt(j - 1));

                // Add edge to the node on the right side
                if(keyboardRowLength - j > 1)
                    g.nodeCollection.get(keyboard[i].charAt(j)).addEdge(keyboard[i].charAt(j+1));

                // Add edge to the node on the top
                if(i > 0)
                    g.nodeCollection.get(keyboard[i].charAt(j)).addEdge(keyboard[i-1].charAt(j));

                // Add edge to the node on the bottom
                if(keyboardRows - i > 1)
                    g.nodeCollection.get(keyboard[i].charAt(j)).addEdge(keyboard[i + 1].charAt(j));

            }
        }
        return g;
    }

}
