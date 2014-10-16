/**
 * Created by Dustin Walker on 10/16/2014
 */
public class SmartStackList {

    // Setting up the stack
    private Node stackInitialNode = new Node();
    private Node endOfStackNode = stackInitialNode;
    private Node sortedCurrentNode = new Node();
    private Node sortedInitialNode = sortedCurrentNode;
    private int sizeCounter;

    /**
     * This push method adds a new value to the stack and to the sorted array.
     * Stack part is finished.
     */
    public void push(int newValue){
        sizeCounter++;
        // Stack code
        Node newStackNode = new Node(newValue);
        endOfStackNode.setNextNode(newStackNode);
        newStackNode.setPreviousNode(endOfStackNode);
        endOfStackNode = newStackNode;
        // Sorted array code
        Node newSortedNode = new Node(newValue);
        sortedCurrentNode = sortedInitialNode;
        while(sortedCurrentNode.getNextNode()!=null){
            if(sortedCurrentNode.getNextNode().getValue()<=newSortedNode.getValue())
                sortedCurrentNode = sortedCurrentNode.getNextNode();
            else{
                break;
            }
        }
        newSortedNode.setNextNode(sortedCurrentNode.getNextNode());
        sortedCurrentNode.setNextNode(newSortedNode);
        sortedCurrentNode.getNextNode().setPreviousNode(sortedCurrentNode);
    }

    /**
     * This pop method removes an element off the stack
     */
    public void pop(){
        sizeCounter--;
        // Stack code
        int searchValue = endOfStackNode.getValue();
        endOfStackNode = endOfStackNode.getPreviousNode();
        endOfStackNode.setNextNode(null);
        // Sorted array code
        sortedCurrentNode = sortedInitialNode;
        while(sortedCurrentNode.getValue()!=searchValue){
            sortedCurrentNode = sortedCurrentNode.getNextNode();
        }
        if(sortedCurrentNode.getNextNode()!=null) {
            sortedCurrentNode.getPreviousNode().setNextNode(sortedCurrentNode.getNextNode());
            sortedCurrentNode.getNextNode().setPreviousNode(sortedCurrentNode.getPreviousNode());
        } else {
            sortedCurrentNode.getPreviousNode().setNextNode(null);
        }
    }

    /**
     * This method displays how many elements are in the stack
     */
    public void size(){
        System.out.println("The Smart Stack List contains "+this.sizeCounter+" elements.");
    }

    /**
     * This method removes all elements greater than the input value from the stack.
     */
    public void removeGreater(int inputValue){
        // TODO Write the removeGreater method.
    }

    /**
     * This method displays the stack in order from the most recently added node
     * to the oldest addition.
     */
    public void displayStack(){
        System.out.print("Stack order: ");
        while(endOfStackNode.getPreviousNode().getPreviousNode()!=null){
            System.out.print(endOfStackNode.getValue()+", ");
            endOfStackNode = endOfStackNode.getPreviousNode();
        }
        System.out.println(endOfStackNode.getValue());
    }

    /**
     * Displays the ordered list.
     */
    public void displayOrdered(){
        System.out.print("Sorted order: ");
        sortedCurrentNode = sortedInitialNode.getNextNode();
        while(sortedCurrentNode.getNextNode()!=null){
            System.out.print(sortedCurrentNode.getValue()+", ");
            sortedCurrentNode = sortedCurrentNode.getNextNode();
        }
        System.out.println(sortedCurrentNode.getValue());
    }

}
