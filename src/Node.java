/**
 * Created by Dustin Walker on 10/16/2014 at 00:54.
 * LINK - link to the program description
 * ${PROJECT_NAME} program description
 */
public class Node {
    /**
     * This constructor is used to set up the initial node
     */
    public Node() { setValue(Integer.MIN_VALUE);   }

    /**
     * This is the main constructor. Sets up the node with the input value.
     * @param newValue Value to pass to the node.
     */
    public Node(int newValue) {
        setValue(newValue);
    }

    private Node nextNode;
    private Node previousNode;
    private int value;

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * This method resets a node to the empty list state.
     */
    public void resetNode(){this.value = Integer.MIN_VALUE; this.nextNode=null;}
}
