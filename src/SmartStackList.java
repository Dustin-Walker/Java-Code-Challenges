/**
 * Created by Dustin Walker on 10/16/2014
 */
public class SmartStackList {

    // Setting up the stack
    private Node stackInitialNode = new Node();
    private Node endOfStackNode = stackInitialNode;
    private Node sortedInitialNode = new Node();
    private Node sortedCurrentNode = sortedInitialNode;
    private int sizeCounter;

    /**
     * This push method adds a new value to the stack and to the sorted array.
     * Stack part is finished.
     */
    public void push(int newValue){
        sizeCounter++;
        // Stack code
        // Is this the first item on the stack?
        if(endOfStackNode.getValue()==Integer.MIN_VALUE){
            endOfStackNode.setValue(newValue);
        } else {
        // Create a new node and push it onto the stack
            Node newStackNode = new Node(newValue);
            endOfStackNode.setNextNode(newStackNode);
            newStackNode.setPreviousNode(endOfStackNode);
            endOfStackNode = newStackNode;
        }
        // Sorted array code
        // Is this the first item in the array?
        if(sortedCurrentNode.getValue()==Integer.MIN_VALUE){
            sortedCurrentNode.setValue(newValue);
        } else {
            Node newSortedNode = new Node(newValue);
            sortedCurrentNode = sortedInitialNode;
            while (sortedCurrentNode.getNextNode() != null) {
                if (sortedCurrentNode.getValue() <= newSortedNode.getValue()) {
                    // Swap
                    //Node tempNode = sortedCurrentNode;


                    sortedCurrentNode = sortedCurrentNode.getNextNode();
                }
                else {
                    break;
                }
            }
            newSortedNode.setNextNode(sortedCurrentNode.getNextNode());
            sortedCurrentNode.setNextNode(newSortedNode);
            sortedCurrentNode.getNextNode().setPreviousNode(sortedCurrentNode);
        }
    }

    /**
     * This pop method removes an element off the stack
     */
    public void pop(){
        sizeCounter--;
        // Stack code
        int searchValue = endOfStackNode.getValue();
        if(endOfStackNode.getPreviousNode()!=null){
            endOfStackNode = endOfStackNode.getPreviousNode();
        }
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
            if(sortedCurrentNode.getPreviousNode()!=null) {
                sortedCurrentNode.getPreviousNode().setNextNode(null);
            }
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
        // Stack code
        endOfStackNode = stackInitialNode;
        while(endOfStackNode.getNextNode()!=null){
            endOfStackNode = endOfStackNode.getNextNode();
            if(endOfStackNode.getValue()>inputValue){
                if(endOfStackNode.getPreviousNode()!=null)
                    endOfStackNode.getPreviousNode().setNextNode(endOfStackNode.getNextNode());
                if(endOfStackNode.getNextNode()!=null)
                    endOfStackNode.getNextNode().setPreviousNode(endOfStackNode.getPreviousNode());
            }
        }
        if(endOfStackNode.getValue()>inputValue) {
            endOfStackNode = endOfStackNode.getPreviousNode();
            endOfStackNode.setNextNode(null);
        }
        // Sorted array code
        // Find the appropriate value and just unhook the list
        sortedCurrentNode = sortedInitialNode;
        while(sortedCurrentNode.getValue()<=inputValue) {
            if(sortedCurrentNode.getNextNode()!=null)
                sortedCurrentNode = sortedCurrentNode.getNextNode();
            else{break;}
        }
        if(sortedCurrentNode.getValue()>inputValue) {
            if (sortedCurrentNode.getNextNode() != null)
                sortedCurrentNode.setNextNode(null);
            if(sortedCurrentNode.getPreviousNode()!=null) {
                sortedCurrentNode.getPreviousNode().setNextNode(null);
            } else {
              // Last item in the array
                sortedCurrentNode.setValue(Integer.MIN_VALUE);
            }
        }
    }

    /**
     * This method displays the stack in order from the most recently added node
     * to the oldest addition.
     */
    public void displayStack(){
        System.out.print("Stack order: ");
        while(endOfStackNode.getPreviousNode()!=null){
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
        sortedCurrentNode = sortedInitialNode;
        while(sortedCurrentNode.getNextNode()!=null){
            if(sortedCurrentNode.getValue()!=Integer.MIN_VALUE) {
                System.out.print(sortedCurrentNode.getValue() + ", ");
                sortedCurrentNode = sortedCurrentNode.getNextNode();
            }
        }
        if(sortedCurrentNode.getValue()!=Integer.MIN_VALUE) {
            System.out.print(sortedCurrentNode.getValue());
        }
        System.out.println();
    }

}
