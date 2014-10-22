public class Main {

    public static void main(String[] args) {
        SmartStackList smartStackList = new SmartStackList();

        smartStackList.push(2);
        smartStackList.push(3);
        smartStackList.push(6);
        smartStackList.push(1);
        smartStackList.push(4);
        smartStackList.displayOrdered();
        smartStackList.pop();
        smartStackList.pop();
        smartStackList.pop();
        smartStackList.displayOrdered();
        smartStackList.push(5);
        smartStackList.push(1);
        smartStackList.push(6);
        smartStackList.push(-40);
        smartStackList.push(-41);
        smartStackList.displayStack();
        smartStackList.size();
        smartStackList.displayOrdered();
        smartStackList.removeGreater(-50);
        smartStackList.displayOrdered();
        smartStackList.displayStack();
        smartStackList.size();
    }
}
