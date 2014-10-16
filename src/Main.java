public class Main {

    public static void main(String[] args) {
        SmartStackList smartStackList = new SmartStackList();

        smartStackList.push(2);
        smartStackList.push(3);
        smartStackList.push(1);
        smartStackList.push(4);
        smartStackList.pop();
        smartStackList.push(5);
        smartStackList.push(1);
        smartStackList.push(6);
        smartStackList.displayStack();
        smartStackList.size();
        smartStackList.displayOrdered();
        smartStackList.removeGreater(0);
        smartStackList.displayOrdered();
        smartStackList.displayStack();

        // TODO Unit tests.
        // TODO Fix error in stack section of removeGreater method. Last element is staying on stack.
        // TODO Fix error where sorted order is not putting element in the first position if necessary.
    }
}
