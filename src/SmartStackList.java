/**
 * Created by Dustin Walker on 10/16/2014
 */
public class SmartStackList {

    // Setting up the stack
    private Node stackInitialNode = new Node();
    private Node endOfStackNode = stackInitialNode;
    private Node beginningSortedListNode = new Node();
    private Node currentSortedListNode = beginningSortedListNode;
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
        Node newNode = new Node(newValue);
        currentSortedListNode = beginningSortedListNode;
        // Is the list empty?
        if(currentSortedListNode.getValue()==Integer.MIN_VALUE){
            currentSortedListNode.setValue(newValue);
            return;
        }
        // Insert at the beginning?
        if(newNode.getValue()<=currentSortedListNode.getValue()){
            newNode.setNextNode(currentSortedListNode);
            beginningSortedListNode = newNode;
            return;
        }
        // Find the appropriate space in the list
        while(currentSortedListNode.getNextNode()!=null && currentSortedListNode.getNextNode().getValue()<newNode.getValue()){
            currentSortedListNode = currentSortedListNode.getNextNode();
        }
        // Insert the new node after the current node
        if(currentSortedListNode.getNextNode()!=null)
            newNode.setNextNode(currentSortedListNode.getNextNode());
        currentSortedListNode.setNextNode(newNode);
    }


    /**
     * This pop method removes an element off the stack
     */
    public void pop(){
        if(this.sizeCounter>0)
            sizeCounter--;
        // Stack code
        int removalValue = endOfStackNode.getValue();
        if(endOfStackNode.getPreviousNode()!=null){
            endOfStackNode = endOfStackNode.getPreviousNode();
            endOfStackNode.setNextNode(null);
        } else {
            endOfStackNode.resetNode();
        }
        // Sorted array code
        currentSortedListNode = beginningSortedListNode;
        if(currentSortedListNode.getValue()==Integer.MIN_VALUE)
            return;
        if(currentSortedListNode.getValue()==removalValue && currentSortedListNode.getNextNode()!=null){
            // Remove from the beginning of the list
            beginningSortedListNode = currentSortedListNode.getNextNode();
        }
        if(currentSortedListNode.getValue()==removalValue){
            currentSortedListNode.resetNode();
        }
        // Find the node to be removed
        while(currentSortedListNode.getNextNode()!=null && currentSortedListNode.getNextNode().getValue()!=removalValue)
            currentSortedListNode = currentSortedListNode.getNextNode();
        if(currentSortedListNode.getNextNode()!=null) {
            if(currentSortedListNode.getNextNode().getNextNode() != null)
                currentSortedListNode.setNextNode(currentSortedListNode.getNextNode().getNextNode());
            else
                currentSortedListNode.setNextNode(null);
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
            if(endOfStackNode.getValue()>inputValue){
                if(this.sizeCounter>0)
                    sizeCounter--;
                if(endOfStackNode.getPreviousNode()!=null)
                    endOfStackNode.getPreviousNode().setNextNode(endOfStackNode.getNextNode());
                if(endOfStackNode.getNextNode()!=null)
                    endOfStackNode.getNextNode().setPreviousNode(endOfStackNode.getPreviousNode());
            }
            endOfStackNode = endOfStackNode.getNextNode();
        }
        // Check the final element on the stack
        if(endOfStackNode.getValue()>inputValue){
            if(this.sizeCounter>0)
                sizeCounter--;
            if(endOfStackNode.getPreviousNode()==null){
                // This is the only node in the stack
                endOfStackNode.resetNode();
            } else {
                // This is not the only node in the stack
                endOfStackNode = endOfStackNode.getPreviousNode();
                endOfStackNode.setNextNode(null);
            }
        }
        // Sorted array code

    }

    /**
     * This method displays the stack in order from the most recently added node
     * to the oldest addition.
     */
    public void displayStack(){
        System.out.print("Stack sorted order: ");
        while(endOfStackNode.getPreviousNode()!=null){
            System.out.print(endOfStackNode.getValue()+", ");
            endOfStackNode = endOfStackNode.getPreviousNode();
        }
        if(endOfStackNode.getValue()!=Integer.MIN_VALUE)
            System.out.println(endOfStackNode.getValue());
    }

    /**
     * Displays the ordered list.
     */
    public void displayOrdered(){
        currentSortedListNode = beginningSortedListNode;
        System.out.print("Ascending sorted order: ");
        while(currentSortedListNode.getNextNode()!=null) {
            System.out.print(currentSortedListNode.getValue() + ", ");
            currentSortedListNode = currentSortedListNode.getNextNode();
        }
        if(currentSortedListNode.getValue()!=Integer.MIN_VALUE)
            System.out.println(currentSortedListNode.getValue());
        else
            System.out.println();
    }

}
