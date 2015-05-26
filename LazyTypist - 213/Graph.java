import java.util.HashMap;

/**
 * Created by Dustin on 5/17/15.
 * This graph represents a keyboard where the nodes are keys and the edges describe which keys are adjacent
 * to each other.
 */
public class Graph {

   // public Graph(String[] keyboardString){}

    public Graph(){}

    public HashMap<String, Node> nodeCollection = new HashMap<String, Node>();

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
        Graph graph = new Graph();
        for (int i = 0; i < keyboardRows; i++) {
            int keyboardRowLength = keyboard[i].length();
            for (int j = 0, spaceCounter = 0, shiftCounter = 0, emptyCounter = 0; j < keyboardRowLength; j++) {
                String currentKey = String.valueOf(keyboard[i].charAt(j));

                // Only allow for 2 space characters in a qwerty layout
                if (emptyCounter > 1 && currentKey.equals(" "))
                    continue;

                // Convert non-alphabetic characters into appropriate key values
                switch (currentKey) {
                    case " ":
                        currentKey = currentKey.concat(String.valueOf(emptyCounter++));
                        break;
                    case "#":
                        currentKey = currentKey.concat(String.valueOf(spaceCounter++));
                        break;
                    case "^":
                        currentKey = currentKey.concat(String.valueOf(shiftCounter++));
                        break;
                }

                graph.addNode(new Node(currentKey));

                // Add edge to node on the left side
                if(j > 0 && !(currentKey.charAt(0)=='#'))
                    graph.nodeCollection.get(currentKey).addEdge(edgeCharParser(currentKey, keyboard[i].charAt(j - 1)));

                // Add edge to the node on the right side
                if(keyboardRowLength - j > 1 && !(currentKey.charAt(0)=='#'))
                    graph.nodeCollection.get(currentKey).addEdge(edgeCharParser(currentKey, keyboard[i].charAt(j + 1)));

                // Add edge to the node on the top
                if(i > 0)
                    graph.nodeCollection.get(currentKey).addEdge(edgeCharParser(currentKey, keyboard[i -1].charAt(j)));

                // Add edge to the node on the bottom, skip spaces here
                if(keyboardRows - i > 1 && !(keyboard[i + 1].charAt(j) ==' '))
                    graph.nodeCollection.get(currentKey).addEdge(edgeCharParser(currentKey, keyboard[i + 1].charAt(j)));
            }
        }
        return graph;
    }

    /**
     * Method to convert a keyboard key to the appropriate hash key value. Only works for qwerty keyboard layouts.
     * This method is to be used in the keyboardToGraph method.
     * @param nodeKey the 'node' key
     * @param edgeKey the 'edge' key
     * @return Key value to be used in the node collection hash table
     */
    private String edgeCharParser(String nodeKey, char edgeKey){

        // Find appropriate shift key
        if(edgeKey == '^'){
            assert nodeKey.equals("a") || nodeKey.equals("z") || nodeKey.equals(" ");
            if (nodeKey.equals("a") || nodeKey.equals("z"))
                return "^0";
            if (nodeKey.equals(" "))
                return "^1";
        }

        // Find appropriate space key
        if(edgeKey == '#'){
            assert nodeKey.equals("c") || nodeKey.equals("v") || nodeKey.equals("b") || nodeKey.equals("n") || nodeKey.equals("m");
            if (nodeKey.equals("c"))
                return "#0";
            if (nodeKey.equals("v"))
                return "#1";
            if (nodeKey.equals("b"))
                return "#2";
            if (nodeKey.equals("n"))
                return "#3";
            if (nodeKey.equals("m"))
                return "#4";
        }

        // Find appropriate empty key
        if(edgeKey == ' '){
            assert nodeKey.equals("p") || nodeKey.equals("l") || nodeKey.equals("m") || nodeKey.equals("^");
            if (nodeKey.equals("p"))
                return " 0";
            else
                return " 1";
        }

        return String.valueOf(edgeKey);
    }

}
